package com.huatech.boot.java.juc.concurrent.synz;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @description: 模拟银行转钱
 * @author: SongXY
 * @create: 2021-11-08 21:01
 **/
@Data
public class T1 {
    private String name;
    private Integer account;


    @SneakyThrows
    private synchronized void set(String name, Integer account) {

            this.name = name;
            TimeUnit.SECONDS.sleep(2);
            this.account = account;
    }

    private synchronized Integer get(String name) {

        return this.account;

    }

    @SneakyThrows
    public static void main(String[] args) {
        T1 t1 = new T1();
        new Thread(() -> {
            t1.set("aaa", 100);
        }).start();
        System.out.println(t1.get("aaa"));

    }
}
