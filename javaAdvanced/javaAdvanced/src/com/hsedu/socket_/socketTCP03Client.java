package com.hsedu.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class socketTCP03Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        //ͨ������������������ݵ�����ͨ����ʹ���ַ���
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello serve");
        //����һ�����з�����ʾд�����ݽ�����ע�⣺Ҫ��Է�ʹ��readLine()
        bufferedWriter.newLine();
        //���ʹ�õ��ַ�������Ҫ�ֶ�ˢ�£��������ݲ���д������ͨ��
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
