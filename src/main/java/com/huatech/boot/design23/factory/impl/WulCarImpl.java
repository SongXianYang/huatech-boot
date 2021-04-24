package com.huatech.boot.design23.factory.impl;

import com.huatech.boot.design23.factory.Car;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-23 22:41
 **/
public class WulCarImpl implements Car {
    @Override
    public void name() {
        System.out.println("五零汽车");
    }
}
