package com.hsedu.udp_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpSenderB {
    public static void main(String[] args) throws Exception{
        //准备在98端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //封装要发送的数据
        byte[] data="明天吃火锅".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.104"), 9999);
        socket.send(packet);



        //接收从A端回复的信息
        //接收数据
        byte[] bytes=new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        //3 把packet进行拆包取出数据
        int length=packet.getLength();
        data=packet.getData();
        String s = new String(data,0, length);
        System.out.println(s);
        System.out.println("B 退出");


        socket.close();
        System.out.println("B 退出");
    }
}
