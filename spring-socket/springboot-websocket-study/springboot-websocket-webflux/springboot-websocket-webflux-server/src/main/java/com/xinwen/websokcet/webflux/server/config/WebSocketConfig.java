package com.xinwen.websokcet.webflux.server.config;

import com.xinwen.websokcet.webflux.server.handler.ReactiveWebSocketServerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenlx
 * @description
 * @date 2025/2/28 15:46
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public HandlerMapping webSocketMapping(ReactiveWebSocketServerHandler reactiveWebSocketServerHandler) {
        final Map<String, WebSocketHandler> map = new HashMap<>(1);
        map.put("/websocket/**", reactiveWebSocketServerHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
