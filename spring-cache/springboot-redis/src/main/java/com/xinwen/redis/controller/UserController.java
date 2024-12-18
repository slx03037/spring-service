package com.xinwen.redis.controller;


import com.xinwen.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-15 22:04
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getById")
    public  Object getById(Integer id){
      return  userService.getById(id);
    }
}
