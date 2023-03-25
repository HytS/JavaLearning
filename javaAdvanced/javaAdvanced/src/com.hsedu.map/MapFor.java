package com.hsedu.map;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","arche");
        map.put("no2","mary");
        map.put("no3","abgai");
        map.put("no4","dutch");

        //
        System.out.println("----��ǿfor----");
        //��ȡ�����е�key��ͨ��keyȡ����Ӧ��value
        Set set = map.keySet();
        for (Object key :set) {
            System.out.println("key="+key+" value="+map.get(key));

        }
        //������
        System.out.println("----������----");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key=iterator.next();
            System.out.println(key+" "+map.get(key));
        }

        //�����е�valuesȡ��
        Collection values = map.values();
        System.out.println("---ȡ�����е�values----");
        for (Object value :values) {
            System.out.println(value);
        }

        System.out.println("---ȡ�����е�values������---");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            Object value=iterator1.next();
            System.out.println(value);
        }

        //ͨ��EntrySet��ȡk-v

        Set entrySet = map.entrySet();
        System.out.println("---for��ǿ---");
        for (Object entry:entrySet) {
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        //ʹ�õ�����
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            Object entry=iterator2.next();
            //System.out.println(entry.getClass());//class java.util.HashMap$Node ʵ��Map.Entry<>
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
    }
}
