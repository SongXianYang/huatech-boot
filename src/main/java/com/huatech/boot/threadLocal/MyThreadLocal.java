package com.huatech.boot.threadLocal;

import com.huatech.boot.User;
import com.huatech.boot.entity.Cat;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 测试ThreadLocal 哈哈
 * @author: SongXY
 * @create: 2021-08-02 15:01
 **/
@Slf4j
public class MyThreadLocal {
    public static void main(String[] args) {
        //多线程访问时，数据间隔离。一个线程只持有一个对象
        ThreadLocal<Cat> threadLocal = new ThreadLocal<>();

        for (int i = 1, size = 10; i <= size; i++) {
            Cat cat = new Cat();

            int finalI = i;
            new Thread(() -> {
                cat.setId(finalI);
                cat.setAge(finalI);
                cat.setName("我家的土猫：" + finalI);
                cat.setSex("男");
                threadLocal.set(cat);

                log.info("main: " + threadLocal.get());
                threadLocal.remove();

                log.info("main: " + threadLocal.get());
            }, "sxy"+i).start();
        }

    }
}
