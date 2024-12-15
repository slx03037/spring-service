package com.xinwen.redis.service;


import com.xinwen.redis.domain.User;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-15 22:01
 **/

public interface UserService {

    void createUser(User user);

    User getById(int id);

    void updateUser(User user);

    void deleteById(int id);

}
