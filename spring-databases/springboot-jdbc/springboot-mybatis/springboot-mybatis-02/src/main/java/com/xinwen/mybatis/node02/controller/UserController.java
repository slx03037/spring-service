package com.xinwen.mybatis.node02.controller;


import com.xinwen.mybatis.node02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-12 18:32
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getAllDevs")
    public List<Map<String, Object>> getAllDevs(){
        return this.userService.getAllDevs();
    }

    @RequestMapping("getAllProds")
    public List<Map<String, Object>> getAllProds(){
        return this.userService.getAllProds();
    }
}
