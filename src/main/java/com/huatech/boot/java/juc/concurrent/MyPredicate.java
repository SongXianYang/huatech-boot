package com.huatech.boot.java.juc.concurrent;

import java.util.function.Predicate;

/**
 * @description: 表示一个参数的谓词（布尔值函数）。
 * @author: SongXY
 * @create: 2021-06-02 22:02
 **/
public class MyPredicate {
    public static void main(String[] args) {
        Predicate<String> predicate =(s)->{
            return s.isEmpty();
        };
        System.out.println(predicate.test(""));
    }
}
