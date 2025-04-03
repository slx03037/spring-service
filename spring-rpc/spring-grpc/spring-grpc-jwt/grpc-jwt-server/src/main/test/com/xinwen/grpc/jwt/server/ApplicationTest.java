package com.xinwen.grpc.jwt.server;

import com.xinwen.grpc.jwt.server.interceptor.AuthInterceptor;
import com.xinwen.grpc.jwt.server.service.HelloServiceImpl;
import com.xinwen.grpc.jwt.server.service.LoginServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author shenlx
 * @description
 * @date 2025/3/31 17:19
 */
@SpringBootTest
public class ApplicationTest {
    Server server;

    @Autowired
    LoginServiceImpl loginService;

    @Autowired
    HelloServiceImpl helloService;

    @Autowired
    AuthInterceptor authInterceptor;

    @Test
    public void test() throws IOException, InterruptedException {
         server = ServerBuilder.forPort(15501)
                .addService(loginService)
                .addService(ServerInterceptors.intercept(helloService, authInterceptor))
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
        blockUntilShutdown();
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if(server !=null){
            server.awaitTermination();
        }
    }
}
