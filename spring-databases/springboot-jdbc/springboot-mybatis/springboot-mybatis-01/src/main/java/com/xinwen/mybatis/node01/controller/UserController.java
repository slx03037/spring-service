package com.xinwen.mybatis.node01.controller;


import com.xinwen.mybatis.node01.domain.User;
import com.xinwen.mybatis.node01.mode.Result;
import com.xinwen.mybatis.node01.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 21:29
 **/
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping( value = "/queryUser")
    public User queryStudentBySno(String sno) {
        return this.userService.queryStudentBySno(sno);
    }


}
