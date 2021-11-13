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
                synchronized (MyCountDownLatch.class) {
                    System.out.println(Thread.currentThread().getName()+"Go----");
                    countDownLatch.countDown(); //他做减减操作
                }
            },"线程"+i).start();
        }
        countDownLatch.await();//等上面执行完了才会执行下面的代码

        System.out.println("递减完了执行下面的代码");
    }
}
