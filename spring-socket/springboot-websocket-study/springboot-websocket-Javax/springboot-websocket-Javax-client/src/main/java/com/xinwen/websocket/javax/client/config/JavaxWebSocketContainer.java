//package com.xinwen.websocket.javax.client.config;
//
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.ServletContextAware;
//import org.springframework.web.socket.client.WebSocketClient;
//
//import javax.servlet.ServletContext;
//import javax.websocket.ContainerProvider;
//import javax.websocket.WebSocketContainer;
//import java.net.URI;
//
///**
// * @author shenlx
// * @description
// * @date 2025/2/26 16:41
// */
//@Component
//@Slf4j
//public class JavaxWebSocketContainer implements ServletContextAware {
//
//    private volatile WebSocketContainer container;
//
//    @Bean
//    public WebSocketContainer getContainer() throws Exception {
//        if(container ==null){
//            synchronized(this) {
//                if(container==null){
//                    container= ContainerProvider.getWebSocketContainer();
//                    URI uri = new URI("ws://localhost:9188/websocket/types");
//                    container.connectToServer(WebSocketClient.class, uri);
//
////                    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
////                    container.connectToServer(this, URI.create("ws://localhost:9188/websocket/types"));
//                }
//            }
//
//        }
//        return container;
//    }
//
//    @Override
//    public void setServletContext(@NonNull ServletContext servletContext) {
//        if (container==null){
//            container=(WebSocketContainer) servletContext.getAttribute("javax.websocket.server.ServerContainer");
//        }
//    }
//}
