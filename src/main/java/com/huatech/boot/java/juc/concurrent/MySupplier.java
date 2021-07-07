package com.huatech.boot.java.juc.concurrent;

import java.util.function.Supplier;

/**
 * @description: 生产者    我就负责生产，给返回
 * @author: SongXY
 * @create: 2021-06-02 21:45
 **/
public class MySupplier {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 666;
        ;
//        {
//            @Override
//            public Integer get() {
//                return 666;
//            }
//        };
        System.out.println(supplier.get());
    }
}
