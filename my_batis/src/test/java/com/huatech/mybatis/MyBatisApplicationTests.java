package com.huatech.mybatis;

import com.huatech.mybatis.entity.User;
import com.huatech.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j

@SpringBootTest
class MyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> all = userMapper.findAll();
        all.forEach(user -> {
            System.out.println(user);
        });

    }

}
