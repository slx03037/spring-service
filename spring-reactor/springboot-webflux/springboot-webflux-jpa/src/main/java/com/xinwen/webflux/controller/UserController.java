package com.xinwen.webflux.controller;

import com.xinwen.webflux.entity.User;
import com.xinwen.webflux.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 23:41
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("getAllUser")
    public Flux<User> getAllUser() {
        Flux<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/getUserById")
    public Mono<User> getUserById(String userId) {
        Mono<User> user = userService.getUserById(userId);
        Mono<User> userMono = user.filter(o -> Objects.nonNull(o))
                .switchIfEmpty(Mono.error(new RuntimeException("500")))
                .onErrorResume(e -> Mono.just(new User()));
        return userMono;
    }

    @PostMapping("/createUser")
    public Mono<User> createUser(@RequestBody User user) {
        Mono<User> user1 = userService.createUser(user);
        return user1;
    }

    @PostMapping("/updateUser")
    public Mono<ResponseEntity<User>> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/deleteUser")
    public Mono<ResponseEntity<Void>> deleteUser(String userId) {
        Mono<ResponseEntity<Void>> responseEntityMono = userService.deleteUser(userId).map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
        return responseEntityMono;
    }
}