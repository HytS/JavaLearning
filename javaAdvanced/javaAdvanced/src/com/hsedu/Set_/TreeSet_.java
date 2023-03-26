package com.hsedu.Set_;


import java.util.Comparator;

public class TreeSet {
    public static void main(String[] args) {
        TreeSet treeSet1 = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });


    }
}
