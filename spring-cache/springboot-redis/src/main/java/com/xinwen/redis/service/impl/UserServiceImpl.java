package com.xinwen.redis.service.impl;


import com.xinwen.redis.domain.User;
import com.xinwen.redis.mapper.UserMapper;
import com.xinwen.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-15 22:02
 **/
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, User> redisTemplate;
    /**
     * 创建用户
     * 不会对缓存做任何操作
     */
    @Override
    public void createUser(User user) {
        logger.info("创建用户start...");
        userMapper.insert(user);
    }

    /**
     * 获取用户信息
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     *
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public User getById(int id) {
        logger.info("获取用户start...");
        // 从缓存中获取用户信息
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            logger.info("从缓存中获取了用户 id = " + id);
            return user;
        }

        // 缓存不存在，从 DB 中获取
        User user = userMapper.selectById(id);
        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);

        return user;
    }

    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @param user 用户
     */
    @Override
    public void updateUser(User user) {
        logger.info("更新用户start...");
        userMapper.updateById(user);
        int userId = user.getId();
        // 缓存存在，删除缓存
        String key = "user_" + userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时候，从缓存中删除用户 >> " + userId);
        }
    }

    /**
     * 删除用户
     * 如果缓存中存在，删除
     */
    @Override
    public void deleteById(int id) {
        logger.info("删除用户start...");
        userMapper.deleteById(id);

        // 缓存存在，删除缓存
        String key = "user_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("更新用户时候，从缓存中删除用户 >> " + id);
        }
    }
}
