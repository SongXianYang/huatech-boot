package com.huatech.boot.java.juc.concurrent;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-11-05 22:23
 **/
public class ProductConsumer {

    private ReentrantLock lock = new ReentrantLock();

    Condition product = lock.newCondition();
    Condition consumer = lock.newCondition();

    CountDownLatch countDownLatch =new CountDownLatch(1);

    private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    /**
     * 生产者生产  消息
     *
     * @param msg
     */
    private  void productM(String msg) {
        lock.lock();
        try {
            queue.add(msg);
            consumer.signal();
            product.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void consumerM() {
        lock.lock();
        try {
            System.out.println(queue.poll());
            product.signal();
            consumer.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProductConsumer productConsumer = new ProductConsumer();
        new Thread(()->{
            for (int i = 0, size = 5; i < size; i++) {
                productConsumer.productM("消息"+i);
            }
        }).start();
        new Thread(()->{
            for (int i = 0, size = 7; i < size; i++) {
                productConsumer.consumerM();
            }
        }).start();
    }
}
