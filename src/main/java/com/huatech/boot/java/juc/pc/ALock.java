package com.huatech.boot.java.juc.pc;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: Lock锁生产者消费者
 * @author: SongXY
 * @create: 2021-05-14 15:49
 **/
public class ALock {
    public static void main(String[] args) {
        Data1 data1 = new Data1();
        new Thread(() -> {
            for (int i = 0, size = 10; i < size; i++) {
                data1.in();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0, size = 10; i < size; i++) {
                data1.on();
            }
        }, "B").start();
//        new Thread(() -> {
//            for (int i = 0,size=10; i < size; i++) {
//
//            }
//        }, "C");
    }
}

@Data
class Data1 {
    private int number=0;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public void in() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "---->" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void on() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "---->" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
