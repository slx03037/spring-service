package com.xinwen.websocket.sockeio.server.service;

/**
 * @author shenlx
 * @description
 * @date 2025/3/3 11:27
 */
public interface ISocketIOService {
    /**
     * 启动服务
     */
    void start();

    /**
     * 停止服务
     */
    void stop();

    /**
     * 推送信息给指定客户端
     *
     * @param userId:     客户端唯一标识
     * @param msgContent: 消息内容
     */
    void pushMessageToUser(String userId, String msgContent);
}
