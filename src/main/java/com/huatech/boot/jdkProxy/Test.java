package com.huatech.boot.jdkProxy;

import com.huatech.boot.jdkProxy.impl.DogImpl;
import com.huatech.boot.jdkProxy.impl.DogProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 启动代理类
 * @author: SongXY
 * @create: 2021-04-27 20:07
 **/
public class Test {
    public static void main(String[] args) {
        //new 一个真是对象
        Dog dog = new DogImpl();
        InvocationHandler proxy = new DogProxy(dog);
        ClassLoader classLoader = dog.getClass().getClassLoader();
        Class<?>[] interfaces = dog.getClass().getInterfaces();
        Dog o = (Dog) Proxy.newProxyInstance(classLoader, interfaces, proxy);
        String s = o.eat("小汪");
        System.out.println(s);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
