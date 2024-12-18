package com.xinwen.netty.module.netty.marshalling.client;

import com.xinwen.netty.module.netty.marshalling.MarshallingCodeCfactory;
import com.xinwen.netty.module.netty.marshalling.ReqData;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @author shenlx
 * @description
 * @date 2024/2/27 14:51
 */
public class Client {
    public static void main(String[] args) throws Exception {

        //线程工作组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //辅助类 帮我我们创建netty服务
        Bootstrap b = new Bootstrap();
        b.group(workerGroup)//绑定两个工作组
                .channel(NioSocketChannel.class)//设置NIO模式
                //初始化绑定服务通道
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //序列化
                        sc.pipeline().addLast(MarshallingCodeCfactory.buildMarshallingEncoder());
                        sc.pipeline().addLast(MarshallingCodeCfactory.buildMarshallingDecoder());
                        //为通道进行初始化：数据传输过来的时候会进行拦截和执行 (可以有多个拦截器)
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });
        ChannelFuture cf = b.connect("127.0.0.1", 8765).syncUninterruptibly();
        for (int i = 0; i < 10; i++) {
            ReqData resqData = new ReqData();
            resqData.setId("" + i);
            resqData.setName("test" + i);
            resqData.setAge(i);
            cf.channel().writeAndFlush(resqData);
        }
        //释放连接
        cf.channel().closeFuture().sync();
        workerGroup.shutdownGracefully();


    }
}
