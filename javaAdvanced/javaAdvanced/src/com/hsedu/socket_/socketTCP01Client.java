package com.hsedu.socket_;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class socketTCP01Client {
    public static void main(String[] args) throws Exception{
        //连接本机的9999端口，如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket返回="+socket.getClass());
        //连接上后，生成socket，
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());

        outputStream.close();
        socket.close();
        System.out.println("客户端结束");
    }
}
