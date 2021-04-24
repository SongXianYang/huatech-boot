package com.huatech.boot.design23.abstractFactoryPattern;

import com.huatech.boot.design23.abstractFactoryPattern.impl.HUAWEIProduceFactoryImpl;
import com.huatech.boot.design23.abstractFactoryPattern.impl.XiaoMiProduceFactoryImpl;

/**
 * @description: 客户端
 * @author: SongXY
 * @create: 2021-04-24 13:22
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("-------------------华为系列产品----------------------");
        HUAWEIProduceFactoryImpl huaweiProduceFactory = new HUAWEIProduceFactoryImpl();
        huaweiProduceFactory.phone().sendMessage();
        huaweiProduceFactory.phone().playGames();
        huaweiProduceFactory.router().wifi();
        huaweiProduceFactory.router().settings();
        System.out.println("---------------小米系列产品---------------------");
        XiaoMiProduceFactoryImpl xiaoMiProduceFactory = new XiaoMiProduceFactoryImpl();
        xiaoMiProduceFactory.phone().playGames();
        xiaoMiProduceFactory.phone().sendMessage();
        xiaoMiProduceFactory.router().settings();
        xiaoMiProduceFactory.router().wifi();
    }
}
