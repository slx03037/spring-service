package com.xinwen.websocket.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.xinwen.websocket.socketio.cache.ClientCache;
import com.xinwen.websocket.socketio.pojo.MessageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @author shenlx
 * @description
 * @date 2025/3/3 11:59
 */
@Component
public class SocketIOHandler {
    @Resource
    private ClientCache clientCache;

    /**
     * @Description //TODO 客户端连接的时候触发，前端js触发：socket = io.connect("http://localhost:9092");
     **/
    @OnConnect
    public void onConnect(SocketIOClient client){
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        UUID sessionId = client.getSessionId();
        clientCache.saveClient(userId,sessionId, client);
        System.out.println("userId: "+userId+"连接建立成功 - "+sessionId);
    }

    /**
     * @Description //TODO 客户端关闭连接时触发：前端js触发：socket.disconnect();
     **/
    @OnDisconnect
    public void onDisconnect(SocketIOClient client){
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        UUID sessionId = client.getSessionId();
        clientCache.deleteSessionClientByUserId(userId,sessionId);
        System.out.println("userId: "+userId+"连接关闭成功 - "+sessionId);
    }

    /**
     *  //TODO 自定义消息事件，客户端js触发:socket.emit('messageevent', {msgContent: msg});时触发该方法
     *  //TODO 前端js的 socket.emit("事件名","参数数据")方法，是触发后端自定义消息事件的时候使用的
     *  //TODO 前端js的 socket.on("事件名",匿名函数(服务器向客户端发送的数据))为监听服务器端的事件
     **/
    @OnEvent("chatevent")
    public void chatEvent(SocketIOClient client, AckRequest ackRequest, MessageInfo message){
        HashMap<UUID, SocketIOClient> userClient = clientCache.getUserClient("79");
        Iterator<Map.Entry<UUID, SocketIOClient>> iterator = userClient.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<UUID, SocketIOClient> next = iterator.next();
            next.getValue().sendEvent("chatevent", message);
        }
        System.out.println(message);
    }
}