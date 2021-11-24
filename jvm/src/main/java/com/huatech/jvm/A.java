package com.huatech.jvm;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-11-21 14:18
 **/
public class A {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new A();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a1.getClass().getClassLoader());
        System.out.println(a1.getClass().getClassLoader().getParent());
        System.out.println(a1.getClass().getClassLoader().getParent().getParent());
    }

    public void b() {

    }

    public void c() {

    }
}
