package com.huatech.mybatis.web;

import com.huatech.mybatis.entity.Param;
import com.huatech.mybatis.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-12 15:35
 **/
@RestController
public class UserWeb {
    @Resource
    private UserService userService;
    @PostMapping("/findMysqlAndEs")
    Map<String, Object> findMysqlAndEs(@RequestBody Param param) {
        Map<String, Object> map = userService.findMysql(param);
        return map;
    }
}
