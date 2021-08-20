package com.huatech.spring.agent;

import com.huatech.spring.agent.classTest.DogCglibProxy;
import com.huatech.spring.agent.interfaceTest.CatImpl;
import com.huatech.spring.agent.interfaceTest.CatProxy;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-20 16:06
 **/
public class Main {
    public static void main(String[] args) {
        //jdk  动态代理  接口
        Cat cat = new CatImpl();
//        cat.play("小花猫");
        CatProxy proxy = new CatProxy(cat);
        Cat catProxy = (Cat) Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(), proxy);
        catProxy.play("小花猫");

        //cglib 代理  类

        Dog dog = new Dog();
        DogCglibProxy dogCglibProxy = new DogCglibProxy(dog);
        Dog dogCglibProxyCglibProxy = (Dog) dogCglibProxy.getCglibProxy();
        dogCglibProxyCglibProxy.paly("汪汪队");



    }
}
