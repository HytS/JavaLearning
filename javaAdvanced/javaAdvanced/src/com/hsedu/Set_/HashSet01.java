package com.hsedu.Set_;



import java.util.HashSet;

public class HashSet01 {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();

        //可以通过remove删除指定元素

        hashSet=new HashSet();
        hashSet.add("mary");
        hashSet.add("mary");
        hashSet.add(new Dog("tom"));
        hashSet.add(new Dog("tom"));
        System.out.println("hashset="+hashSet);

        hashSet.add(new String("hs"));
        hashSet.add(new String("hs"));

        System.out.println("set="+hashSet);
    }
}

class Dog{
    public   String name;
    public Dog(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "Dog="+name;
    }
}
