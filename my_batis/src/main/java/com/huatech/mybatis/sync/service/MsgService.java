/*******************************************************************************
 * Package: com.huatech.mybatis.sync.service
 * Type:    MsgService
 * Date:    2022-01-01 21:09
 *
 * Copyright (c) 2022 HUANENG GUICHENG TRUST CORP.,LTD All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *******************************************************************************/
package com.huatech.mybatis.sync.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 发短信 业务层
 *
 * @author Songxianyang
 * @date 2022-01-01 21:09
 */
@Slf4j
@Service
public class MsgService {
    //定义生成策略
    public static final String CODE_id = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    /**
     * 生成验证码
     * @return 4位
     */
    public String createCode() {
        
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=CODE_id.charAt(new Random().nextInt(CODE_id.length()));
            sb.append(ch);
        }
        return sb.toString();
    }
    
    /**
     * 发生验证码
     * @param code 4验证码
     * @return code
     */
    @Async
    public void sendCode(String code) throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
//        throw new RuntimeException("故意异常");
        log.info("发生给用户:");
        log.info("【SteveCode】验证码：{}，您正在使用SteveCode，需要进行验证，请勿向任何人提供您收到的短信验证码。", code);
    }
    /**
     * 我添加了一个分支叫test
     */
}
