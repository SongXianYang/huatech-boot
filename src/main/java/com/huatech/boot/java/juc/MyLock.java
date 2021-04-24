package com.huatech.boot.java.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 实现线程安全  锁
 * @author: SongXY
 * @create: 2021-03-31 20:58
 **/
public class MyLock {
    public static void main(String[] args) {
        HelloLock helloLock = new HelloLock();
        new Thread(helloLock,"一号窗口").start();
        new Thread(helloLock,"2号窗口").start();
        new Thread(helloLock,"3号窗口").start();
    }
}
class HelloLock implements Runnable{

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try {
            int ticket = 100;
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "售票完成" + --ticket);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }
}
