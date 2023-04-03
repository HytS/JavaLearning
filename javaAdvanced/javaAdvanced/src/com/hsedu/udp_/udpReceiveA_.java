package com.hsedu.udp_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpReceiveA_ {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] buf=new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
        System.out.println("接收端A等待数据");

        datagramSocket.receive(datagramPacket);

        //对packet进行拆包
        int length=datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //回复消息给B
        data="好的，明天见".getBytes();
        byte[] bytes =new byte[1024];
        datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.104"),9998);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();


        System.out.println("A 退出");




    }
}
