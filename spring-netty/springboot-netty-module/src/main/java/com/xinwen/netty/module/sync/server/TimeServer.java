package com.xinwen.netty.module.sync.server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shenlx
 * @description
 * @date 2024/2/20 11:18
 */
public class TimeServer {
    public static void main(String[]args) throws IOException {
        int port=8080;

        ServerSocket server=null;
        
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket=null;
            while (true){
                socket=server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        }finally {
            if(server !=null){
                System.out.println("The time server close");
                server.close();
                server=null;
            }
        }
    }
}
