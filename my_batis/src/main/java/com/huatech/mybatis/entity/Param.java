package com.huatech.mybatis.entity;

import lombok.Data;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 15:44
 **/
@Data
public class Param {
    /**
     * 参数   MySQL  还是  es
     */
    private String type;
    /**
     * 输入得内容
     */
    private String inputParam;
}
