package com.huatech.boot.design23.factory.impl;

import com.huatech.boot.design23.factory.Car;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-23 21:25
 **/
public class JieDaCarImpl implements Car {
    public JieDaCarImpl() {
        this.name();
    }

    @Override
    public void name() {
        System.out.println("捷达汽车");
    }
}
