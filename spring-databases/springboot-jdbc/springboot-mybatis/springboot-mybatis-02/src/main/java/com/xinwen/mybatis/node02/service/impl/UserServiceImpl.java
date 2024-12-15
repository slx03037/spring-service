package com.xinwen.mybatis.node02.service.impl;


import com.xinwen.mybatis.node02.mapper.dev.UserDevMapper;
import com.xinwen.mybatis.node02.mapper.prod.UserProdMapper;
import com.xinwen.mybatis.node02.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-12 18:30
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDevMapper userDevMapper;
    @Resource
    private UserProdMapper userProdMapper;


    @Override
    public List<Map<String, Object>> getAllDevs() {
        return userDevMapper.getAlls();
    }

    @Override
    public List<Map<String, Object>> getAllProds() {
        return userProdMapper.getAlls();
    }
}
