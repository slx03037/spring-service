package com.xinwen.tco.udp.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author shenlx
 * @description
 * @date 2024/2/8 14:36
 */
public class MultiplexerTimeServer implements Runnable{
    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile  boolean stop;

    /**
     * 初始化多路复用器，绑定监听端口
     */
    public MultiplexerTimeServer(int port){
        try{
            selector=Selector.open();

            serverSocketChannel=ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("The time server is start in port:"+port);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop=true;
    }


    @Override
    public void run() {
        while(!stop){
            try{
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key=null;
                while(it.hasNext()){
                    key=it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch (Exception e){
                        if(key !=null){
                            key.cancel();
                            if(key.channel() !=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("IOException:"+e.getMessage());
            }catch (Throwable t){
                t.printStackTrace();
                System.out.println("IOException:"+t.getMessage());
            }
        }
        /**多路复用器关闭后，所有注册在上面的channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源*/
        if(selector !=null){
            try{
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            //处理新接入的请求消息
            if(key.isAcceptable()){
                //accept the new connection
                ServerSocketChannel ssc=(ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //add the new connection to the selector
                sc.register(selector,SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                //read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if(readBytes>0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("The time server receive order:"+body);
                    String currentTime="QUERY TIME ORDER".equalsIgnoreCase("body")?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                    dowrite(sc,currentTime);
                }else if(readBytes <0){
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                }else {
                    //读到0字节，忽略
                }
            }
        }
    }

    private void dowrite(SocketChannel channel,String response) throws IOException {
        if(response !=null && response.trim().length()>0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
