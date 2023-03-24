package com.hsedu.List_;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListSource {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        for (int i = 1; i < 2; i++) {
            linkedList.add(i);
        }
        linkedList.add(100);
        linkedList.add(100);
//        linkedList.remove();
//        for (Object obj: linkedList) {
//            System.out.println(obj);
//        }
//
//        linkedList.set(0,"hs");
//        System.out.println("==============");
//        for (Object obj :linkedList) {
//            System.out.println(obj);
//        }
//        Object obj=linkedList.get(0);
//        System.out.println("obj="+obj);
//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());

        //使用迭代器
        Iterator iterator=linkedList.iterator();
        while (iterator.hasNext()) {
            Object next=iterator.next();
            System.out.println("next="+next);
        }
        System.out.println("=====linklist增强for");
        for (Object obj :linkedList) {
            System.out.println(obj);
        }
    }
}
