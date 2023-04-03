package com.hsedu.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork01Serve {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        //读取客户端写入数据通道的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        String answer="";

        if ("name".equals(s)){
            System.out.println("my name is hs");
        }else if ("hobby".equals(s)){
            System.out.println("program java ");
        }else {
            System.out.println("what are you say");
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
