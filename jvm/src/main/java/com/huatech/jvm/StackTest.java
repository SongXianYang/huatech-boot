package com.huatech.jvm;

/**
 * @description: 栈:放的是 方法 常量池 final修饰的常量  static 修饰的变量与方法
 * @author: SongXY
 * @create: 2021-11-24 16:50
 **/
public class StackTest {
    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.b();
        stackTest.c();
    }
    public void b() {
        c();
    }

    public void c() {
        b();
    }
}
