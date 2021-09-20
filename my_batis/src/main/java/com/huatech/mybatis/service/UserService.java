package com.huatech.mybatis.service;

import com.huatech.mybatis.entity.Param;
import com.huatech.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 15:39
 **/
public interface UserService {
    /**
     * MySQL查询
     * @param param
     * @return
     */
    Map<String, Object> findMysql(Param param);

    /**
     * es查询
     * @return
     */
    Map<String, Object> findEs();

}
