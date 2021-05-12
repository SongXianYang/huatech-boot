package com.huatech.boot.java.juc;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 测试lock锁
 * @author: SongXY
 * @create: 2021-05-12 19:00
 **/
public class TestLock {
    public static void main(String[] args) {
        Ticket02 ticket = new Ticket02();
        new Thread(() -> {
            for (int i = 0, size = 30; i < size; i++) {
                ticket.sell();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0, size = 30; i < size; i++) {
                ticket.sell();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0, size = 30; i < size; i++) {
                ticket.sell();
            }
        }, "C").start();

    }
}

@Data
class Ticket02 {
    private int number = 20;
    Lock lock = new ReentrantLock();

    public void sell() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "个" + ",剩余" + number + "个");
            }
        } finally {
            lock.unlock();
        }
    }
}
