package com.hsedu.socket_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class HomeWork02Sender {
    public static void main(String[] args) throws Exception{
        //׼����98�˿ڽ�������
        DatagramSocket socket = new DatagramSocket(9998);
        //��������
        Scanner scanner = new Scanner(System.in);
        System.out.println("input your question");
        String question = scanner.next();
        byte[] data=question.getBytes();

        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.104"), 8888);
        socket.send(packet);



        //���մ�A�˻ظ�����Ϣ
        //��������
        byte[] bytes=new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);



        //3 ��packet���в��ȡ������
        int length=packet.getLength();
        data=packet.getData();
        String s = new String(data,0, length);
        System.out.println(s);

        socket.close();
        System.out.println("B �˳�");
    }
}
