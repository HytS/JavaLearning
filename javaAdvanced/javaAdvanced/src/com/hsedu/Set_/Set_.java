package com.hsedu.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_ {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("mark");
        set.add("henry");
        set.add(null);
        set.add(null);
        set.add("tom");
        set.add("jack");
        for (int i = 0; i <10; i++) {
            System.out.println("set="+set);
        }

        //������ʽ
        //����������
        System.out.println("====������=====");
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            Object obj=iterator.next();
            System.out.println("obj="+obj);
        }
        //��ǿfor
        System.out.println("====��ǿfor===");
        for (Object obj : set) {
            System.out.println("obj="+obj);
        }
    }
}
