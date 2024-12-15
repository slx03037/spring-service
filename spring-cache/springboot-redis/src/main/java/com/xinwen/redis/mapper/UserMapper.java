package com.xinwen.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.xinwen.redis.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-15 21:56
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
}
