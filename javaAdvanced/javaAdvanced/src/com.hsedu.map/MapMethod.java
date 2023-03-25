package com.hsedu.map;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
            Map map = new HashMap();
            map.put("no1","as");
            map.put(null,"tom");

            map.remove(null);

        System.out.println(map.get("no1"));

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        System.out.println(map.containsKey("no1"));
    }
}
