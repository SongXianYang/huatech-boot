package com.huatech.boot.jdkProxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 小狗的代理类
 * @author: SongXY
 * @create: 2021-04-27 19:57
 **/
public class DogProxy implements InvocationHandler {
    private Object object;

    //代理的真是对象
    public DogProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法调用之前");
        Object o = method.invoke(object, args);
        System.out.println("方法调用之后");
        return o;
    }

}
