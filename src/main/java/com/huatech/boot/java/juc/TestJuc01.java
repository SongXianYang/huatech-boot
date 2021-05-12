package com.huatech.boot.java.juc;

import lombok.Data;

/**
 * @description: 测试线程
 * @author: SongXY
 * @create: 2021-05-11 17:14
 **/
public class TestJuc01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0,size=30 ; i <size; i++) {
                ticket.sell();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0,size=30 ; i <size; i++) {
                ticket.sell();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0,size=30 ; i <size; i++) {
                ticket.sell();
            }
        },"C").start();

    }
}
@Data
class Ticket {
    private int number = 20;

    public synchronized void sell() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出第"+(number--)+"个"+",剩余"+number+"个");
        }
    }
}
