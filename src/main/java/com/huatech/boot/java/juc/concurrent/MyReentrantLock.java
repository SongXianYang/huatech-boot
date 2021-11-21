package com.huatech.boot.java.juc.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 联系加锁
 * @author: SongXY
 * @create: 2021-11-13 17:20
 **/
public class MyReentrantLock {
    ReentrantLock lock = new ReentrantLock(true);

    @SneakyThrows
    public static void main(String[] args) {
        MyReentrantLock my = new MyReentrantLock();
        for (int i = 0, size = 2; i < size; i++) {
            int finalI = i;
            TimeUnit.SECONDS.sleep(1);

            new Thread(()->{
                my.test1(finalI);
            }).start();
        }
//        new Thread(my::tryLock).start();
    }



    private  void test1(int i) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"kskskks"+i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    private void tryLock() {
        lock.tryLock(4,TimeUnit.SECONDS);
        try {
            System.out.println("hhahaha-"+"tryLock");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
