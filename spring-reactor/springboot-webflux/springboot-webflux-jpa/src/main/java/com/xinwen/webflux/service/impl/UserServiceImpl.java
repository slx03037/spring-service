package com.xinwen.webflux.service.impl;

import com.xinwen.webflux.entity.User;
import com.xinwen.webflux.mapper.UserMapper;
import com.xinwen.webflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 22:08
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Flux<User> getAllUsers() {
        return userMapper.findAll();
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public Mono<User> createUser(User user) {
        return userMapper.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return userMapper.findById(user.getId()).flatMap(u -> {
            u.setUserName(user.getUserName());
            u.setUserNo(user.getUserNo());
            u.setUserId(user.getUserId());
            u.setMobile(user.getMobile());
            u.setPassWord(user.getPassWord());
            u.setMobile(user.getMobile());
            return userMapper.save(u);
        });
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userMapper.deleteById(id);
    }
}
