package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description: 线程自增计数器
 * @author: SongXY
 * @create: 2021-05-18 09:26
 **/
public class MyCyclicBarrier {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙！！！");
        });

        for (int i = 1, size = 7; i <= size; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }
    }
}
