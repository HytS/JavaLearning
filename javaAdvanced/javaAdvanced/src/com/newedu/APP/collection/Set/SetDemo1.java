package com.newedu.APP.collection.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo1 {
    public static void main(String[] args) {
//        Set<Apple> apples = new TreeSet<>();
//        apples.add(new Apple("ab",12.2,23));
//        apples.add(new Apple("ab",12.2,230));
//        apples.add(new Apple("ab",12.2,2300));
//        System.out.println(apples);

//        Set<Apple> apples = new TreeSet<>(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight()-o2.getWeight();
//            }
//        });
//        apples.add(new Apple("ab",12.2,23));
//        apples.add(new Apple("ab",12.2,230));
//        apples.add(new Apple("ab",12.2,2300));
//        System.out.println(apples);

        Set<Apple> apples = new TreeSet<>((o1, o2) -> {return o1.getWeight()-o2.getWeight();});
        apples.add(new Apple("ab",12.2,23));
        apples.add(new Apple("ab",12.2,230));
        apples.add(new Apple("ab",12.2,2300));
        System.out.println(apples);
    }
}
