package com.xinwen.netty.module.netty.xml.node01.client;

import com.xinwen.netty.module.netty.xml.common.OrderFactory;
import com.xinwen.netty.module.netty.xml.node01.utils.request.HttpXmlRequest;
import com.xinwen.netty.module.netty.xml.node01.utils.response.HttpXmlResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * @author shenlx
 * @description
 * @date 2024/2/29 21:44
 */
public class HttpXmlClientHandle extends SimpleChannelInboundHandler<HttpXmlResponse> {
    protected void channelActive(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 给客户端发送请求消息，HttpXmlRequest包含FullHttpRequest和Order这个了类
        HttpXmlRequest request = new HttpXmlRequest(null, OrderFactory.create(123));
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpXmlResponse msg) throws Exception {
        System.out.println("The Client receive respon of http header is :"+msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is :"+msg.getResult());
    }
}
