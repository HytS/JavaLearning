package com.hsedu.socket_;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTCP01 {
    public static void main(String[] args) throws Exception{
        //Ҫ���ڱ���û�����������ڼ���9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("�������9999�˿ڵȴ�����");
        //��û�пͻ�������9999�˿�ʱ�����������
        //�пͻ������ӣ��᷵��socket���󣬳������
        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());

        InputStream inputStream = socket.getInputStream();
        //IO��ȡ
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
