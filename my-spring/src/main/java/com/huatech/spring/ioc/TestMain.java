package com.huatech.spring.ioc;


import com.huatech.spring.ioc.context.MyAnnotationConfigApplicationContext;

/**
 * @description: 启动类
 * @author: SongXY
 * @create: 2021-08-07 17:50
 **/
public class TestMain {
    public static void main(String[] args) {
        MyAnnotationConfigApplicationContext context = new MyAnnotationConfigApplicationContext("com.huatech.spring.ioc");
        System.out.println(context.getBean("cat"));
    }
}
