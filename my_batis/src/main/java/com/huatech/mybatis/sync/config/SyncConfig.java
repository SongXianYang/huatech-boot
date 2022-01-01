/*******************************************************************************
 * Package: com.huatech.mybatis.sync.config
 * Type:    SyncConfig
 * Date:    2022-01-01 21:22
 *
 * Copyright (c) 2022 HUANENG GUICHENG TRUST CORP.,LTD All Rights Reserved.
 *
 * You may not use this file except in compliance with the License.
 *******************************************************************************/
package com.huatech.mybatis.sync.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步的一个配置
 *
 * @author Songxianyang
 * @date 2022-01-01 21:22
 */
@EnableAsync
@Configuration
public class SyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(8);
        // 设置最大线程数
        executor.setMaxPoolSize(20);
        // 设置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 设置线程活跃时间(秒)
        executor.setKeepAliveSeconds(60);
        // 设置线程名前缀+分组名称
        executor.setThreadNamePrefix("AsyncOperationThread-");
        executor.setThreadGroupName("AsyncOperationGroup");
        // 所有任务结束后关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 初始化
        executor.initialize();
        return executor;
    }
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
