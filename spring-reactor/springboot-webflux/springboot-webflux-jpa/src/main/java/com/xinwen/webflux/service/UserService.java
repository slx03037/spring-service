package com.xinwen.webflux.service;

import com.xinwen.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 22:08
 */
public interface UserService {

    Flux<User> getAllUsers();

    Mono<User> getUserById(String id);

    Mono<User> createUser(User user);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(String id);
}
