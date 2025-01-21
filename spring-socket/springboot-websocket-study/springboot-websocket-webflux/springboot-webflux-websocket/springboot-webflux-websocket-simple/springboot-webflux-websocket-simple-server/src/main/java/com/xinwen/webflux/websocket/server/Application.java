package com.xinwen.webflux.websocket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 9:24
 */
@SpringBootApplication
@EnableWebFlux
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}
