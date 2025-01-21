package com.xinwen.webclient.config;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;


/**
 * @author shenlx
 * @description
 * @date 2025/1/22 16:52
 */

@Configuration
public class HTTPConfig {

    @Value("${common.connect.timeout}")
    private int connectionTimeout;

    @Value("${common.request.timeout}")
    private int requestTimeout;

    @Value("${common.read.timeout}")
    private int readTimeout;

    @Bean
    public HttpClient httpClient(){
        return    HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,connectionTimeout)
                    .responseTimeout(Duration.ofMillis(requestTimeout))
                    .doOnConnected(conn->conn.addHandlerFirst(new ReadTimeoutHandler(readTimeout)));
    }

    /**
     * 创建网络客户端
     */
    @Bean
    public WebClient webClient(){
//        return WebClient.builder()
//                .baseUrl("https://echo.apifox.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//                .build();

        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient())).build();
    }

}
