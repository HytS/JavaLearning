package com.hsedu.map;

import java.util.Properties;

public class properties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john",100);
        properties.put("jake",100);
        properties.put("jake",1000);
        System.out.println("properties="+properties);
    }
}
