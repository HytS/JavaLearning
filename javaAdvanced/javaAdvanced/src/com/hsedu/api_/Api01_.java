package com.hsedu.api_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Api01_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-ASPILS4V/192.168.0.104

        InetAddress byName = InetAddress.getByName("LAPTOP-ASPILS4V");
        System.out.println("byname="+byName);

        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println("byname1="+byName1);

        String hostAddress = byName1.getHostAddress();
        System.out.println("byname1对应的ip="+hostAddress);

        String hostName = byName1.getHostName();
        System.out.println("byname1对应的主机名="+hostName);
    }
}
