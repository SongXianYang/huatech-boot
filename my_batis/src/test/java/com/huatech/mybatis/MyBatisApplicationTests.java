package com.huatech.mybatis;

import com.huatech.mybatis.entity.User;
import com.huatech.mybatis.entity.es.EsUser;
import com.huatech.mybatis.mapper.UserMapper;
import com.huatech.mybatis.mapper.es.EsUserMapper;
import com.huatech.mybatis.mapper.impl.UserMapperImpl;
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
    private UserMapperImpl userMapper;

    @Autowired
    private EsUserMapper esUserMapper;

    @Test
    void contextLoads() {
        List<User> all = userMapper.findAll();
        all.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    void getId() {
        User user = userMapper.getId(1007);
        System.out.println(user);
    }

    @Test
    void esFindAll() {
        Iterable<EsUser> all = esUserMapper.findAll();
        all.forEach(esUser -> {
            System.out.println(esUser);
        });
    }

}
