/*******************************************************************************
 * Package: com.huatech.mybatis.sync.web
 * Type:    TestSyncWeb
 * Date:    2022-01-01 21:48
 *
 * Copyright (c) 2022 HUANENG GUICHENG TRUST CORP.,LTD All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *******************************************************************************/
package com.huatech.mybatis.sync.web;

import com.huatech.mybatis.sync.service.MsgService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试异步方法调用
 *
 * @author Songxianyang
 * @date 2022-01-01 21:48
 */
@RestController
@RequestMapping("sync")
public class TestSyncWeb {
    @Resource
    private MsgService msgService;
    
    @SneakyThrows
    @GetMapping("send")
    public String userSendCode() {
        String code = msgService.createCode();
        msgService.sendCode(code);
        return "短信已发送，请注意查收";
    }
}

