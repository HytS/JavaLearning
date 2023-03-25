package com.hsedu.Oop_;

import org.w3c.dom.NameList;

public class Obj01 {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        System.out.println(p1.age);
        // System.out.println();
    }
}

/**
 * Person
 * 同一个类的方法可以调用，不同类的方法需要创建对象调用
 */
 class Person {
    public String name;
    public int age;

    public Person(String name) {
        System.out.println("Person姓名=" + name);
    }

    // 方法的封装
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

/**
 * Student
 */
class Student {

    public int sNo;
    public String name;

    public Student(String name, int sNo) {
        this.name = name;
        this.sNo = sNo;
    }
}