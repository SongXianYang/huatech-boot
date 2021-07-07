package com.huatech.boot.java.juc.concurrent;

import lombok.val;

import java.util.function.Consumer;

/**
 * @description: 消费者，你给我啥我消费啥
 * @author: SongXY
 * @create: 2021-06-02 21:43
 **/
public class MyConsumer {
    public static void main(String[] args) {
       Consumer<String> consumer=(s)->{
           System.out.println(s);
       };
       consumer.accept("sj");
    }
}
