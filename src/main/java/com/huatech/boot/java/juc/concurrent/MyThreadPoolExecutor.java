package com.huatech.boot.java.juc.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 创建线程池的方式
 * @author: SongXY
 * @create: 2021-06-02 16:54
 **/
public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        /*
        执行线程数
        最大执行线程数
        超时时间
        超时时间单位
        阻塞队列
        线程工厂
        无法处理后需要采取的措施
        * */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            for (int i = 1, size = 90; i <= size; i++) {

                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+ "===finalTemp");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
