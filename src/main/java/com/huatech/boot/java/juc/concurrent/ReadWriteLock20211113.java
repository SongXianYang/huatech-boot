package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读锁是共享锁
 * 写锁是排他锁
 * @author: SongXY
 * @create: 2021-11-13 21:43
 **/
public class ReadWriteLock20211113 {
    /**
     * 加上true就是公平锁
     */
    static ReadWriteLock lock = new ReentrantReadWriteLock(true);
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    Integer count;
    public static void main(String[] args) {
        ReadWriteLock20211113 readwrite = new ReadWriteLock20211113();
        //10线程读数据
        for (int i = 0, size = 10; i < size; i++) {
            new Thread(readwrite::read).start();
        }
        //3个线程去写
        for (int i = 0, size = 3; i < size; i++) {
            int finalI = i;
            new Thread(()->{
                readwrite.write(finalI);
            }).start();
        }

    }

    /**
     *读锁是共享锁
     */
    private void read() {
        readLock.lock();
        try {
            System.out.println("start");
            System.out.println("读锁是 共享锁：所有线程都可以进行访问数据-----");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 写锁是排他锁
     * @param v
     */
    private void write(Integer v) {
        writeLock.lock();
        try {
            count = v;
            TimeUnit.SECONDS.sleep(1);
            System.out.println(count+"测试");
            System.out.println("写锁  排他：只支持当前线程去写数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
