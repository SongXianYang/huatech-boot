package com.huatech.mybatis.mapper;

import com.huatech.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-09 22:53
 **/
@Mapper
public interface UserMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param id   s
     * @return
     */
    User getId(@Param("id") Integer id);


    List<User> findAllByParam(String inputParam);
}
