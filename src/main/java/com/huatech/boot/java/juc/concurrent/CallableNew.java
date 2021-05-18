package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @description: 我的  接口
 * @author: SongXY
 * @create: 2021-05-17 17:27
 **/
public class CallableNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1234;
    }
}
