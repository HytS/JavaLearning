package com.newedu.APP.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ColException {
    public static void main(String[] args) {
        //集合遍历删除元素可能出现的并发修改异常
        ArrayList<String> list = new ArrayList<>();
        list.add("heima");
        list.add("heimb");
        list.add("heimb");
        list.add("heimc");
        list.add("heimd");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String ele  = iterator.next();
            if ("heimb".equals(ele)) {
                //集合删除会出异常
//                list.remove(ele);
                //迭代器删除没问题
                iterator.remove();
            }
        }
        System.out.println(list);

        //foreach不能一边遍历一边删除
        //for循环一边遍历一边删除没问题的前提是从后面开始遍历,这样才不会漏删
        for (int i = list.size(); i >0; i--) {
            String ele = list.get(i);
            if ("heimb".equals(ele)) {
                list.remove(ele);
            }
        }
        System.out.println(list);
    }
}
