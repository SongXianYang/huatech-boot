package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 线程递减计数器
 * @author: SongXY
 * @create: 2021-05-17 19:53
 **/
public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1, size = 10; i <= size; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go----");
                countDownLatch.countDown();
            },"线程"+i).start();
        }
        countDownLatch.await();

        System.out.println("递减完了执行下面的代码");
    }
}
