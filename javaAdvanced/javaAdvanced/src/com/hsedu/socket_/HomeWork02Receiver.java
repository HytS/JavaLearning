package com.hsedu.socket_;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HomeWork02Receiver {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] buf=new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);

        System.out.println("wait your question");
        datagramSocket.receive(datagramPacket);

        //对packet进行拆包
        int length=datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);

        String answer="";
        if ("book is what".equals(s)){
            answer="book is ";
        }else {
            answer="what";
        }

        data=answer.getBytes();


        datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.104"),9998);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
        System.out.println("A 退出");
    }
}
