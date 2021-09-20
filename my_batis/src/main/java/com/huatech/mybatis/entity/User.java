package com.huatech.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * @description: 测试用户
 * @author: SongXY
 * @create: 2021-09-09 22:51
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String age;
    private String desc;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;

}
