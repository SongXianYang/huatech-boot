package com.huatech.boot.atomic;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description: 测试原子性
 * @author: SongXY
 * @create: 2021-07-04 16:19
 **/
@Log4j2
public class AtomicTest {
    //并发数
    private static Integer clientTotal = 5000;
    //每次请每次执行的线程数
    private static Integer threadTotal = 200;

    private static int count;

    private static LongAdder count1 = new LongAdder();

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //偏移量
        Semaphore semaphore = new Semaphore(threadTotal);
        //请求的总数
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0, size = clientTotal; i < size; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        try {
            countDownLatch.await();
            executorService.shutdown();
            log.info("到底多少 {}",count1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void add() {
        if (atomicBoolean.compareAndSet(false, true)) {
            count1.increment();
        }
    }
}
