package com.xinwen.webflux.websocket.client.ws;

import com.xinwen.webflux.websocket.client.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author shenlx
 * @description
 * @date 2025/3/1 9:32
 */
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings(value = "unused")
public class AdminWebSocketClient {
    //private final GatewayConfig gatewayConfig;
    private WsWrap wsWrap;

    public void connectAdminWs() {
        try {
            log.info("发送WebSocket连接");
            WebSocketClient client = new ReactorNettyWebSocketClient();
            //String prefix = gatewayConfig.getAdminProps().getUrl();
//            prefix = prefix.replace("http://", "ws://")
//                    .replace("https://", "wss://");
            client.execute(URI.create("ws://" + "/local/ws?id=" + UUID.randomUUID()), session -> {
                        Mono<Void> input = session.receive().doOnNext(webSocketMessage -> messageHandle(session, webSocketMessage))
                                .doOnError(throwable -> log.error("发生异常：" + throwable))
                                .doOnComplete(() -> log.info("WebSocketClient结束")).then();
                        Mono<Void> output = session.send(Flux.create(sink -> wsWrap = new WsWrap(session, sink)));
                        return Mono.zip(input, output).then()
                                .doFinally(signalType -> {
                                    log.error("WebSocket连接断开，5秒后发起重连");
                                    try {
                                        TimeUnit.SECONDS.sleep(5);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    // 重新连接
                                    connectAdminWs();
                                });
                    }).onTerminateDetach().doOnError(throwable -> log.error("发生异常:" + throwable))
                    .subscribe(aVoid -> {
                    });
        } catch (Throwable e) {
            log.error("webSocket连接出错,5秒后发起重连", e);
            try {
                wsWrap.getSession().close();
            } catch (Exception ignore) {
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception ignore) {
            }
            //重连
            connectAdminWs();
        }
    }

    @Data
    @AllArgsConstructor
    private static class WsWrap {
        private WebSocketSession session;
        private FluxSink<WebSocketMessage> sink;

        public void sendText(Object obj) {
            sink.next(session.textMessage(JsonUtils.toJson(obj)));
        }
    }

    private void messageHandle(WebSocketSession session, WebSocketMessage message) {
        switch (message.getType()) {
            case TEXT:
                try {
                    String text = message.getPayloadAsText();
                    // todo 业务处理
                } catch (Exception e) {
                    log.warn("无法处理的消息", e);
                }
                break;
            case BINARY:
            case PING:
            case PONG:
                break;
            default:
        }
    }
}
