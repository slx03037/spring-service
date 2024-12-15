package com.xinwen.websocket.node04.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenlx
 * @description
 * @date 2024/9/16 11:06
 */
//ServerEndpoint它的功能主要是将目前的类定义成一个websocket服务器端。注解的值将被用于监听用户连接的终端访问URL地址。
@ServerEndpoint(value = "/socket/{ip}")
@Component
public class WebSocketServer {
    //使用slf4j打日志
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    //用来记录当前在线连接数
    private static int onLineCount = 0;

    //用来存放每个客户端对应的WebSocketServer对象
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap= new ConcurrentHashMap<String, WebSocketServer>();

    //某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //客户都安IP地址
    private String ip;

    /**
     * 连接建立成功，调用的方法，与前台页面的OnOpen相对应
     * @param ip
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("ip") String ip,Session session){
        //根据业务，自定义逻辑
        this.session=session;
        this.ip=ip;
        //将对象存入map中
        webSocketMap.put(ip,this);
        addOnlineCount();
        logger.info("有新的连接加入，ip:{}!当前在线人数：{}",ip,getOnLineCount());
    }

    /**
     * 连接关闭调用的方法，与前台页面的onclose相对应
     * @param ip
     */
    @OnClose
    public void onclose(@PathParam("ip")String ip){
        webSocketMap.remove(ip);
        subOnlineCount();
        logger.info("websocket关闭，ip:{},当前在线人数：{}",ip,getOnLineCount());
    }

    /**
     * 服务器接收到客户端发送的消息时所调用的方法，与前台页面的onMessage相对应
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        logger.info("接收客户端的消息:{}",message);
    }

    /**
     * 发生错误调用时，与前台页面的onError相对应
     * @param session
     * @param throwable
     */
    public void onError(Session session,Throwable throwable){
        logger.error("websocket连接发生错误");
        throwable.printStackTrace();
    }

    /**
     * 给当前用户发送消息
     * @param message
     */
    public void sendMessage(String message){
        try{
            //getBasicRemote是同步发送消息，这里我就用这个，推荐大家使用getAsyncRemote
            //this.session.getAsyncRemote()
            this.session.getBasicRemote().sendText(message);
        }catch (IOException e){
            e.printStackTrace();
            logger.error("发送数据错误:ip:{},message:{}",ip,message);
        }
    }

    //给所有用户发送消息
    public static void sendMessageAll(final String message){
        //使用entrySet而不是keySet原因，entrySet体现了map的映射关系,遍历获取数据更快
        Set<Map.Entry<String ,WebSocketServer>> entries=webSocketMap.entrySet();
        for (Map.Entry<String,WebSocketServer> entry:entries){
            final WebSocketServer webSocketServer=entry.getValue();
            //这里使用线程来控制消息的发送，这样效率更高
            new Thread(new Runnable() {
                @Override
                public void run() {
                    webSocketServer.sendMessage(message);
                }
            }).start();
        }
    }

    /**
     * 获取当前连接数
     * @return
     */
    public static synchronized int getOnLineCount(){
        return WebSocketServer.onLineCount;
    }

    /**
     * 有新的用户时，连接数加1
     */
    public static synchronized   void addOnlineCount(){
        WebSocketServer.onLineCount++;
    }


    /**
     * 断开连接时，连接数自减1
     */
    public  static synchronized void subOnlineCount(){
        WebSocketServer.onLineCount--;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public static ConcurrentHashMap<String, WebSocketServer> getWebSocketMap() {
        return webSocketMap;
    }

    public static void setWebSocketMap(ConcurrentHashMap<String, WebSocketServer> webSocketMap) {
        WebSocketServer.webSocketMap = webSocketMap;
    }
}
