/*******************************************************************************
 * Package: com.huatech.mybatis.sync.config
 * Type:    CustomAsyncExceptionHandler
 * Date:    2022-01-01 21:28
 *
 * Copyright (c) 2022 HUANENG GUICHENG TRUST CORP.,LTD All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *******************************************************************************/
package com.huatech.mybatis.sync.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 异步异常打印
 *
 * @author Songxianyang
 * @date 2022-01-01 21:28
 */
@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("异常捕获------------");
        log.error("Exception message 异常信息 {}", throwable.getMessage() );
        log.error("Method name 方法名称: {}", method.getName());
    
        for (Object param : objects) {
            System.out.println("Parameter value - " + param);
        }
        
    }
}
