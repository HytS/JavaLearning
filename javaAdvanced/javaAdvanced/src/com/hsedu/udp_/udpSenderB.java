package com.hsedu.udp_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpSenderB {
    public static void main(String[] args) throws Exception{
        //׼����98�˿ڽ�������
        DatagramSocket socket = new DatagramSocket(9998);
        //��װҪ���͵�����
        byte[] data="����Ի��".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.104"), 9999);
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
        System.out.println("B �˳�");


        socket.close();
        System.out.println("B �˳�");
    }
}
