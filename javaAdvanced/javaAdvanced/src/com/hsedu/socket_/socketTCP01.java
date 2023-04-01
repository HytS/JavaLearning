package com.hsedu.socket_;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCP01 {
    public static void main(String[] args) throws Exception{
        //要求在本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口等待连接");
        //当没有客户端连接9999端口时，程序会阻塞
        //有客户端连接，会返回socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());

        InputStream inputStream = socket.getInputStream();
        //IO读取
        int readLen=0;
        byte[] bytes=new byte[1024];
        while ((readLen=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readLen));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
