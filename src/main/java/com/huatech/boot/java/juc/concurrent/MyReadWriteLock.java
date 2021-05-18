package com.huatech.boot.java.juc.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 读写的锁
 * @author: SongXY
 * @create: 2021-05-18 13:54
 **/
public class MyReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1, size = 6; i <= size; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp, temp + "哈哈");
            }, String.valueOf(i)).start();
        }
        for (int i = 1, size = 6; i <= size; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp);
            }, String.valueOf(i)).start();
        }
    }
}

//资源类
class MyCache {
    private Map<Integer, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(Integer key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程，开始存资源，key是：：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "线程，存完了，我走了。key是：：" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(Integer key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取资源值：" + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
