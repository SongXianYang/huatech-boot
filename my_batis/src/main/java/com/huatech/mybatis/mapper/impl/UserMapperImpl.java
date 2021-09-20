package com.huatech.mybatis.mapper.impl;

import com.huatech.mybatis.entity.User;
import com.huatech.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-09 23:00
 **/
@Slf4j
@Service
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

    @Override
    public User getId(Integer id) {
        SqlSession sqlSession = factory.openSession();

        User o = sqlSession.selectOne("com.huatech.mybatis.mapper.UserMapper.getId", 1004);
        log.info("getId:{}",o);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getId(id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findAllByParam(String inputParam) {
        return null;
    }
}
