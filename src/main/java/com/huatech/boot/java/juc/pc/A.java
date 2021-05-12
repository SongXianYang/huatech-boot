package com.huatech.boot.java.juc.pc;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

/**
 * 线程之间的通信问题：生产者和消费者问题！  等待唤醒，通知唤醒
 * 线程交替执行  A   B 操作同一个变量   num = 0
 * A num+1
 * B num-1
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    data.increment();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"C").start();
//
//
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                try {
//                    data.decrement();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"D").start();
    }
}

// 判断等待，业务，通知
@Log4j2
class Data{ // 数字 资源类

    private int number = 0;

    //+1
    public void increment() throws InterruptedException {
        synchronized (this) {
            if (number!=0){  //0
                // 等待
                log.error("increment:number={}" ,number);
                this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            // 通知其他线程，我+1完毕了
            this.notifyAll();
        }
    }

    public void decrement() throws InterruptedException {
        synchronized (this) {
            if (number==0){ // 1
                // 等待
                log.error("decrement: number={}" ,number);
                this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            System.out.println("是否通知我了");
            // 通知其他线程，我-1完毕了
            this.notifyAll();
        }
        }
}
