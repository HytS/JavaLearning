package com.hsedu.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCP03 {
    //客户端连接到服务端发送 hello serve ，接受服务端发的hello client,再退出
    //服务端接受到客户端发出的信息，发送hello client
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s=bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client char");
        bufferedWriter.newLine();
        bufferedWriter.flush();



        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
