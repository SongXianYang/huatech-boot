package com.huatech.boot.design23.abstractFactoryPattern.impl;

import com.huatech.boot.design23.abstractFactoryPattern.Phone;
import com.huatech.boot.design23.abstractFactoryPattern.ProduceFactory;
import com.huatech.boot.design23.abstractFactoryPattern.Router;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-24 13:19
 **/
public class XiaoMiProduceFactoryImpl implements ProduceFactory {
    @Override
    public Phone phone() {
        return new XiaomiPhoneImpl();
    }

    @Override
    public Router router() {
        return new XiaoMiRouterImpl();
    }
}
