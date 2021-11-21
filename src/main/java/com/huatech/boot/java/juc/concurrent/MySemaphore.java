package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 线程型号量
 * @author: SongXY
 * @create: 2021-05-18 10:18
 **/
public class MySemaphore {
    static Semaphore sema = new Semaphore(2);

    public static void main11(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1, size = 9; i <= size; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"号线程，已经占位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"号线程，离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

    public static void main(String[] args) {
        MySemaphore mySemaphore = new MySemaphore();
        new Thread(mySemaphore::t1).start();
        new Thread(mySemaphore::t2).start();
    }

    private void t1() {

        try {
            sema.acquire();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("SemaphoreT1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            sema.release();
        }
    }

    private void t2() {

        try {
            sema.acquire();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("SemaphoreT2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            sema.release();
        }
    }
}
