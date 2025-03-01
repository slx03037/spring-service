package com.xinwen.websocket.webmvc.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketConnectionManager;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author shenlx
 * @description
 * @date 2025/2/27 16:58
 */
@Component
@Slf4j
public class ServletWebSocketClientHandler implements WebSocketHandler {
    /**
     * 当前服务建立与服务端建立的链接信息
     */
    private  WebSocketSession clientSession = null;

    /**
     * 初始化当前重连次数
     */
    private  Integer currentConnectionTimes = 0;

    @Autowired
    @Lazy
    @Qualifier("wsCloudConnectionManager")
    WebSocketConnectionManager wsConnectionManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Websocket client connection established");
        if(session.isOpen()){
            log.info("连接成功");
            this.clientSession = session;
            System.out.println(clientSession);
            System.out.println("获取链接之后的session");
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("接收消息内容:{}", message.getPayload());
        if(message instanceof PongMessage) {
            //此处验证建立链接后消息交互
//            session.sendMessage(new PongMessage(ByteBuffer.wrap("2".getBytes())));
        }else if(message instanceof TextMessage){
            System.out.println("Add message into queue");
        }else if(message instanceof BinaryMessage){
            System.out.println("Receive binary message");
        }else {
            throw new Exception("Error format");
        }
        System.out.println("接受消息ID =================   " + session.getId());
        System.out.println("接收到的消息===============   " + message);
        session.sendMessage(new TextMessage("hello world"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("Websocket client connection closed");
        this.clientSession = null;
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送消息,如果连接断开，缓存到数据库
     *
     * @param content
     *            发送内容
     */
    public void sendMessage(String content) {
        System.out.println("send content >>> " + content);
        if (isConnected()) {
            try {
                System.out.println("send-----1");
                this.clientSession.sendMessage(new TextMessage(content));
                System.out.println("send-----2");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("send-----3");
            }
        } else {
            // cache
            System.out.println("Connection closed ");
            System.out.println("Connection interrupt ");
        }
    }

    @Scheduled(cron = "${websocket.pong.schedule.cron}")
    public void heartBeat() {
        System.out.println("执行定时任务开始");
        System.out.println(isConnected());
        try {
            if (isConnected()) {
                this.clientSession.sendMessage(new PongMessage(ByteBuffer.wrap("1".getBytes())));
            } else {
                System.out.println("Send Ping Message fail, not connect ");
                System.out.println("try " + currentConnectionTimes + " times, connection fail, reconnecting");
                currentConnectionTimes++;
                // 重连
                wsConnectionManager.startInternal();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断连接是否存在
     *
     * @return
     */
    public Boolean isConnected() {
        log.info("状态：{}",this.clientSession);
        log.info("状态：{}",(null != this.clientSession && this.clientSession.isOpen()));
        return null != this.clientSession && this.clientSession.isOpen();
    }

}
