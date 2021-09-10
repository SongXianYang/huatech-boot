package com.huatech.mybatis.mapper.impl;

import com.huatech.mybatis.entity.User;
import com.huatech.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-09 23:00
 **/
public class UserMapperImpl implements UserMapper {
    @Resource
    private SqlSessionFactory factory;

    @Override
    public List<User> findAll() {
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();

        List<User> users = sqlSession.selectList("com.huatech.mybatis.mapper.UserMapper.findAll");
        sqlSession.close();

        return users;
    }
}
