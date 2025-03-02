package com.xinwen.webflux.mapper;

import com.xinwen.webflux.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 22:07
 */
@Repository
public interface UserMapper extends ReactiveCrudRepository<User, String> {
}
