package com.huatech.boot.design23.abstractFactoryPattern;

/**
 * @description: 抽象工厂接口
 * @author: SongXY
 * @create: 2021-04-24 13:10
 **/
public interface ProduceFactory {
    Phone phone();

    Router router();
//    电脑
//    牙刷
//            充电宝
}
