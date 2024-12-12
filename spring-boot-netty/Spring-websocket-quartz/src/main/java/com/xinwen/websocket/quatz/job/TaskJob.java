package com.xinwen.websocket.quatz.job;

import com.xinwen.websocket.quatz.socket.WebSocketServer;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenlx
 * @description
 * @date 2024/9/17 16:42
 */
public class TaskJob {
    public void task(){

        ConcurrentHashMap<String, WebSocketServer> map=WebSocketServer.getWebSocketMap();

        if(map.size() !=0){
            for(Map.Entry<String,WebSocketServer> entry:map.entrySet()){
                WebSocketServer webSocketServer=entry.getValue();
                try{
                    //向客户端发送消息
                    webSocketServer.getSession().getBasicRemote().sendText("每隔两秒钟，向客户都安发送一次数据");
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("websocket未连接");
        }
    }
}
