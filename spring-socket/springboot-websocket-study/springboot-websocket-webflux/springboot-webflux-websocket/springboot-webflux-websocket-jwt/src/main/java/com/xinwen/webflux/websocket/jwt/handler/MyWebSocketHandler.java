package com.xinwen.webflux.websocket.jwt.handler;

import com.xinwen.webflux.websocket.jwt.service.WebSocketPushService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.Mono;

/**
 * @author shenlx
 * @description
 * @date 2025/3/3 13:45
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {

    private final WebSocketPushService pushService;

    public MyWebSocketHandler(WebSocketPushService pushService) {
        this.pushService = pushService;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        pushService.registerSession(session);
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .doOnNext(message -> {
                    pushService.broadcast("Server received: " + message, session.getId());
                })
                .then();
    }
}
