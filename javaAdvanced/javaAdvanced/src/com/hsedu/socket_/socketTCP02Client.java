package com.hsedu.socket_;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class socketTCP02Client {
    public static void main(String[] args) throws  Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello serve".getBytes());

        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        int readLen=0;
        byte[] buf=new byte[1024];
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
//
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("¿Í»§¶Ë½áÊø");

    }
}
