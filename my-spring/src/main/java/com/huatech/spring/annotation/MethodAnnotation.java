package com.huatech.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-15 17:52
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    //方法的功能名称
    String value();
    //操作的是那张表
    String tableName();
}
