package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @description: 表示接受一个参数并产生结果的函数
 * @author: SongXY
 * @create: 2021-06-02 21:56
 **/
public class MyFunction {
    public static void main(String[] args) {
        Function<String,Integer> function=(s)->{return Integer.valueOf(s);};
        System.out.println(function.apply("9"));
        ConcurrentHashMap<Integer, String> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
    }
}
