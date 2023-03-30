package com.hsedu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("no1","tt");//k-v

        /* 1��k-v����� HashMap$Node node = newNode(hash,key,value,null)
           2��k-vΪ�˷�����������ᴴ��EntrySet���ϣ��ü��ϴ�ŵ�Ԫ������Entry����һ��Entry
           �������k��v  EntrySet<Entry<k,v>> �� transient Set<Map.Entry<k,v>> entrySet
           3��entrySet�У���������;���Map.Entry,����ʵ���ϴ�ŵĻ���HashMap$Node
              ������Ϊ static class Node<k,v> implements Map.Entry<k,v>
           4������HashMap$Node�����ŵ�entrySet�У������������ΪMap.Entry�ṩ����Ҫ����
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
