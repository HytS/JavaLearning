package com.hsedu.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class socketTCP03Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，昔日如数据到数据通道，使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello serve");
        //插入一个换行符，表示写入内容结束，注意：要求对方使用readLine()
        bufferedWriter.newLine();
        //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s=bufferedReader.readLine();
        System.out.println(s);



        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
