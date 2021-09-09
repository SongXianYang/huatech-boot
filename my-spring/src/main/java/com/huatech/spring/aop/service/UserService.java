package com.huatech.spring.aop.service;

import com.huatech.spring.annotation.ClassAnnotation;
import com.huatech.spring.annotation.MethodAnnotation;
import com.huatech.spring.aop.bean.Cat1;
import com.huatech.spring.aop.bean.UserBean;
import org.springframework.stereotype.Component;

/**
 * @description: 用户业务层
 * @author: SongXY
 * @create: 2021-08-15 18:19
 **/
@Component
@ClassAnnotation("用户业务层")
public class UserService {


    /**
     * 新增用户
     * @param id
     * @param name
     */
//    @MethodAnnotation(value = "新增用户",tableName = "user")
    public void seve(Integer id,String name) {
        System.out.println("id为："+id+","+"用户名："+name);
    }

    @MethodAnnotation(value = "测试参数是对象怎么解析",tableName = "user")
    public void test(UserBean bean) {
        System.out.println(bean);
    }
}
