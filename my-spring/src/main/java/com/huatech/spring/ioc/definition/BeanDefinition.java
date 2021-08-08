package com.huatech.spring.ioc.definition;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-07 18:18
 **/
@AllArgsConstructor
@Data
public class BeanDefinition {
    /**
     * 对象的class
     */
    private Class beanClazz;
    /**
     * 名称
     */
    private String beanName;


}
