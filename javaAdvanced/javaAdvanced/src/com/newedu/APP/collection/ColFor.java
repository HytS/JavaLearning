package com.newedu.APP.collection;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColFor {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator it = list.iterator();
        while (it.hasNext()){

            System.out.println(it.next());
        }

        for (String list1: list) {
            System.out.println(list1);
        }

        System.out.println("Lambda±í´ïÊ½");
        list.forEach(s->{
            System.out.println(s);
        });
    }
}
