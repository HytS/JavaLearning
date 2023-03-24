package com.hsedu.List_;

import java.util.ArrayList;

public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //无参构造器
        ArrayList List = new ArrayList();
        //ArrayList List = new ArrayList(8);
        for (int i = 0; i <=10; i++) {
            List.add(i);
        }
        for (int i =11; i < 15; i++) {
            List.add(i);
        }
        List.add(100);
        List.add(200);
        List.add(null);

        for (Object obj: List) {
            System.out.println(obj);
        }
    }
}
