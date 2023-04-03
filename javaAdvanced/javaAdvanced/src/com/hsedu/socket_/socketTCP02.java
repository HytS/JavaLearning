package com.hsedu.socket_;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCP02 {
    public static void main(String[] args)  throws  Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket =  serverSocket.accept();

        int readLen=0;
        byte[] buf=new byte[1024];
        InputStream inputStream = socket.getInputStream();
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello Client".getBytes());

        socket.shutdownOutput();
        outputStream.close();
        socket.close();
        inputStream.close();
        serverSocket.close();
    }
}
