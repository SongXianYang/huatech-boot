package com.huatech.boot.java.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 实现线程的方式
 * @author: SongXY
 * @create: 2021-03-31 15:45
 **/
public class MyCallable {
    public static void main(String[] args) {
        HelloCallable callable = new HelloCallable();
        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        new Thread(task).start();
        try {
            Integer sum = task.get();
            System.out.println("sum = " + sum);
            System.out.println("---------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class HelloCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        Integer sum=0;
        for (int i = 0; i <=10000000; i++) {
            sum +=i ;
        }
        return sum;
    }
}
