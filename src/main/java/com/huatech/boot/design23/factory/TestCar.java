package com.huatech.boot.design23.factory;

import com.huatech.boot.design23.factory.impl.DaZongCarImpl;
import com.huatech.boot.design23.factory.impl.JieDaCarImpl;

/**
 * @description: 测试车
 * @author: SongXY
 * @create: 2021-04-23 22:00
 **/
public class TestCar {
    public static void main(String[] args) {
        Car daZong = FactoryCar.getCar("大众汽车");
        Car jieDa = FactoryCar.getCar("捷达汽车");
        final Car 五零 = FactoryCar.getCar("五零");
        五零.name();
        daZong.name();
        jieDa.name();
//        //我们之前是这种new对象的
//         Car daZongCar = new DaZongCarImpl();
//         Car jieDaCar = new JieDaCarImpl();
//        daZongCar.name();
//        jieDaCar.name();
        ///
    }
}
