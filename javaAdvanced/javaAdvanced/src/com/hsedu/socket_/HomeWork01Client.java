package com.hsedu.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HomeWork01Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //�Ӽ��̶�ȡ����
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your question");
        String question = scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //��ȡ���ݲ���ʾ
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
