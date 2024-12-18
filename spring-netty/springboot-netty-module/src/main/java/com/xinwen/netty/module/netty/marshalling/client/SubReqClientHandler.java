package com.xinwen.netty.module.netty.marshalling.client;

import com.xinwen.netty.module.netty.marshalling.ReqData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * @author shenlx
 * @description
 * @date 2024/2/27 14:30
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
    public SubReqClientHandler(){

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i=0;i<10;i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private ReqData subReq(int i){
        ReqData reqData = new ReqData();
        reqData.setId(String.valueOf(i));
        reqData.setName("lisi");
        reqData.setAge(10);

        return reqData;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response :["+ msg +"]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }
}
