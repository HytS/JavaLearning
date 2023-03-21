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

        //遍历方式
        //迭代器遍历
        System.out.println("====迭代器=====");
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            Object obj=iterator.next();
            System.out.println("obj="+obj);
        }
        //增强for
        System.out.println("====增强for===");
        for (Object obj : set) {
            System.out.println("obj="+obj);
        }
    }
}
