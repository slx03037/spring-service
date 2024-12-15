package com.xinwen.mybatis.node01.service;


import com.xinwen.mybatis.node01.domain.User;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 21:26
 **/

public interface UserService {
    int add(User user);
    int update(User user);
    int deleteBysno(String sno);
    User queryStudentBySno(String sno);
}
