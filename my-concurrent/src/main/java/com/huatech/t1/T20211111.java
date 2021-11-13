package com.huatech.t1;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-11-11 22:17
 **/
public class T20211111 {
    static Long countSync = 0L;
    static AtomicLong atomicLong = new AtomicLong();
    LongAdder longAdder = new LongAdder();

    @SneakyThrows
    public static void main(String[] args) {
//        test();
        test1();
        test2();
    }

    private static void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(10);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void test1() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                ksks();
            }).start();
        }
        long ent = System.currentTimeMillis();
        System.out.println(ent - start+"普通时间");
    }

    private static void test2() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                atomicLong();
            }).start();
        }
        long ent = System.currentTimeMillis();
        System.out.println(ent - start+"AtomicLong时间");
    }

    private static void ksks() {
        for (int i = 0, size = 1000; i < size; i++) {
            synchronized (T20211111.class) {
                countSync++;
            }
        }
    }

    private static void atomicLong() {
        for (int i = 0, size = 1000; i < size; i++) {
            synchronized (T20211111.class) {
                atomicLong.incrementAndGet();
            }
        }
    }
}
