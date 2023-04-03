package com.hsedu.map;

import java.util.HashMap;

public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(new A(i),"hello");
        }
        System.out.println("hashMap="+hashMap);
    }
}

class A{
    public  int num;
    public A(int num){
        this.num=num;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
