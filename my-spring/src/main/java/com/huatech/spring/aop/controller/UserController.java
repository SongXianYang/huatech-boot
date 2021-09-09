package com.huatech.spring.aop.controller;

import com.huatech.spring.aop.bean.Cat1;
import com.huatech.spring.aop.bean.UserBean;
import com.huatech.spring.aop.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-10 14:26
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private Cat1 cat1;

    @Resource
    private UserService userService;

    @GetMapping("get")
    public User findUser() {
        User user = new User(1, "宋先阳", 23);
        return user;
    }

    @GetMapping("save/{id}/{name}")
    public void save(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        userService.seve(id, name);
    }

    @GetMapping("getCat")
    public void getCat() {
        UserBean bean = new UserBean();
        bean.setId(1);
        bean.setName("sxy");
        userService.test(bean);
    }
    class User {
        private int id;
        private String name;
        private int age;

        public User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
