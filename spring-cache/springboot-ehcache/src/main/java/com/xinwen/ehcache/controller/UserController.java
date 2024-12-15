package com.xinwen.ehcache.controller;


import com.xinwen.ehcache.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-13 21:11
 **/
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/queryBySno")
    public Object getUser(String sno){
       return userService.queryBySno(sno);
    }
}
