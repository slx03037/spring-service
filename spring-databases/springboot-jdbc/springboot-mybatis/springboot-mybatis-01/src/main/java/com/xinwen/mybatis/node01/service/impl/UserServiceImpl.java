package com.xinwen.mybatis.node01.service.impl;


import com.xinwen.mybatis.node01.domain.User;
import com.xinwen.mybatis.node01.mapper.UserMapper;
import com.xinwen.mybatis.node01.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 21:28
 **/

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteBysno(String sno) {
        return userMapper.deleteBysno(sno);
    }

    @Override
    public User queryStudentBySno(String sno) {
        return userMapper.queryUserBySno(sno);
    }
}
