package com.xinwen.admin.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-22 09:32
 **/
@RestController
public class UserController {
    @GetMapping("/getUsername")
    public String getUsername(){
        return "张三";
    }
}
