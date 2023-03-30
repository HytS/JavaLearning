package com.hsedu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("no1","tt");//k-v

        /* 1、k-v最后是 HashMap$Node node = newNode(hash,key,value,null)
           2、k-v为了方遍遍历。还会创建EntrySet集合，该集合存放的元素类型Entry，而一个Entry
           对象就有k，v  EntrySet<Entry<k,v>> 即 transient Set<Map.Entry<k,v>> entrySet
           3、entrySet中，定义的类型就是Map.Entry,但是实际上存放的还是HashMap$Node
              这是因为 static class Node<k,v> implements Map.Entry<k,v>
           4、当把HashMap$Node对象存放到entrySet中，方便遍历，因为Map.Entry提供了重要方法
           K getKey() V getValue()
        * */

        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object obj :set) {
            Map.Entry entry =(Map.Entry)obj;
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
