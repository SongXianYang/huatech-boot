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
public class CountSync {
    //并发数
    private static Integer clientTotal = 5000;
    //每次请每次执行的线程数
    private static Integer threadTotal = 200;

    private static int count=0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //偏移量
        Semaphore semaphore = new Semaphore(threadTotal);
        //请求的总数
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0, size = clientTotal; i < size; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }


        try {
            countDownLatch.await();
            executorService.shutdown();
            log.info("到底多少 {}", count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void add() {
        synchronized (CountSync.class) {
            count++;
        }
    }
}
