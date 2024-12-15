package com.xinwen.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenlx
 * @description
 * @date 2024/12/12 21:49
 */
@SpringBootApplication
//开启AdminServer功能
@EnableAdminServer
@Configuration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
