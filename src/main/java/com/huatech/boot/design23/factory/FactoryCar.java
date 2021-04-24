package com.huatech.boot.design23.factory;

import com.huatech.boot.design23.factory.impl.DaZongCarImpl;
import com.huatech.boot.design23.factory.impl.JieDaCarImpl;
import com.huatech.boot.design23.factory.impl.WulCarImpl;

/**
 * @description: 简单工厂模式
 * @author: SongXY
 * @create: 2021-04-23 16:34
 **/
public class FactoryCar {
    public static Car getCar(String name) {
        if (name.equals("大众汽车")) {
            return new DaZongCarImpl();
        } else if (name.equals("捷达汽车")) {
            return new JieDaCarImpl();
        } else if (name.equals("五零")) {
            return new WulCarImpl();
        } else {
            return new Car() {
                @Override
                public void name() {
                    System.out.println("我家里没有汽车！");
                }
            };
        }
    }
}
