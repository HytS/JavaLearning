package com.hsedu.socket_;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class socketTCP01Client {
    public static void main(String[] args) throws Exception{
        //���ӱ�����9999�˿ڣ�������ӳɹ�����socket����
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("�ͻ��� socket����="+socket.getClass());
        //�����Ϻ�����socket��
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());

        outputStream.close();
        socket.close();
        System.out.println("�ͻ��˽���");
    }
}
