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
        System.out.println("----增强for----");
        //先取出所有的key，通过key取出对应的value
        Set set = map.keySet();
        for (Object key :set) {
            System.out.println("key="+key+" value="+map.get(key));

        }
        //迭代器
        System.out.println("----迭代器----");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key=iterator.next();
            System.out.println(key+" "+map.get(key));
        }

        //把所有的values取出
        Collection values = map.values();
        System.out.println("---取出所有的values----");
        for (Object value :values) {
            System.out.println(value);
        }

        System.out.println("---取出所有的values迭代器---");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            Object value=iterator1.next();
            System.out.println(value);
        }

        //通过EntrySet获取k-v

        Set entrySet = map.entrySet();
        System.out.println("---for增强---");
        for (Object entry:entrySet) {
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        //使用迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()){
            Object entry=iterator2.next();
            //System.out.println(entry.getClass());//class java.util.HashMap$Node 实现Map.Entry<>
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
    }
}
