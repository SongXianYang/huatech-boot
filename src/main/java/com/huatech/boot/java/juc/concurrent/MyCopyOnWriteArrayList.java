package com.huatech.boot.java.juc.concurrent;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: List    线程安全类
 * @author: SongXY
 * @create: 2021-05-17 12:07
 **/
public class MyCopyOnWriteArrayList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 1, size = 10; i <= size; i++) {
            list.add(UUID.randomUUID().toString().substring(0, 6));
        }
        System.out.println("list1 = " + list);
        A a = new A();
        a.print();
    }
}

class A {
    public void print() {
        ArrayList<String> list = new ArrayList<>();

//        List<String> list = new Vector<>();线程安全
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());//线程安全
//        List<String> list = new CopyOnWriteArrayList<>();//线程安全
        for (int i = 1, size = 20; i <= size; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 6));
                System.out.println("list-- "+Thread.currentThread().getName() + list);
            }, "线程" + i).start();
        }
    }
}

