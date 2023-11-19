package com.newedu.APP.collection.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","age");
        map.put("name","age2");
        map.put("name1","age1");
        map.put("name1",null);
        map.put("name2","age2");
        System.out.println(map);

        //
        System.out.println("��һ�ֱ���");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(value);
        }


        //��ֵ��
        System.out.println("�ڶ��ֱ���");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry:entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key = "+key+" value = "+value);
        }

        //
        System.out.println("�����ֱ���");
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println("key = "+key+" value = "+value);
            }
        });

        System.out.println("��Lambda���ʽ");
        map.forEach((k,v) -> {System.out.println("key = "+k+" value = "+v);});
    }
}
