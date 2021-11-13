package com.huatech.boot.java.juc.concurrent;

import lombok.SneakyThrows;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-11-07 22:25
 **/
public class Join {

    @SneakyThrows
    public static void main(String[] args) {

        T t = new T();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());

        new B().start();
        new C().start();
        new D().start();
    }

}
class T extends Thread{

    @Override
    public void run() {
        System.out.println("T1");
    }
}


class B extends Thread{

    @Override
    public void run() {
        System.out.println("B");
    }
}

class C extends Thread{

    @SneakyThrows
    @Override
    public void run() {
        B b = new B();
        b.join();
        System.out.println("C");
    }
}

class D extends Thread{

    @SneakyThrows
    @Override
    public void run() {
        C c = new C();
        c.join();
        System.out.println("D");
    }
}