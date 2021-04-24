package com.huatech.boot.design23.factory.impl;

import com.huatech.boot.design23.factory.Car;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-23 21:22
 **/
public class DaZongCarImpl implements Car {
    public DaZongCarImpl() {
        this.name();
    }

    @Override
    public void name() {
        System.out.println("大众汽车");
    }
}
