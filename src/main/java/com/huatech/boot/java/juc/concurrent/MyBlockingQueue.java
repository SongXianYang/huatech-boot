package com.huatech.boot.java.juc.concurrent;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: 阻塞队列
 * @author: SongXY
 * @create: 2021-05-24 19:10
 **/
public class MyBlockingQueue {
    public static void main(String[] args) {
        //抛异常的Api
//        test1();
        //不抛异常   返回false
        test2();
    }

    private static void test2() {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(2);
        System.out.println(strings.offer("1"));
        System.out.println(strings.offer("2"));
        System.out.println(strings.offer("3"));
    }

    private static void test1() {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(2);

        System.out.println(strings.add("1"));
        System.out.println(strings.add("2"));
//        System.out.println(strings.add("3"));
        //区队首元素
        System.out.println(strings.element());
        System.out.println(strings.remove());
        System.out.println(strings.remove());
        System.out.println(strings.remove());
    }
}
