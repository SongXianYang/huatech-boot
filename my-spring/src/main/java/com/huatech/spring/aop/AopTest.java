package com.huatech.spring.aop;

import com.huatech.spring.aop.service.UserService;
import com.huatech.spring.utils.ObjReflectionUtil;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-15 18:18
 **/
public class AopTest {
    public static void main(String[] args) throws ClassNotFoundException {
        AopTest aopTest = new AopTest();
        aopTest.testNotStatic();
    }

    private void testNotStatic() throws ClassNotFoundException {
        UserService userService = (UserService) ObjReflectionUtil.newOgj(UserService.class);
        userService.seve(1,"sxy");
    }
}
