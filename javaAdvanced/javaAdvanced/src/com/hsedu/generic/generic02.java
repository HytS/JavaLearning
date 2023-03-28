package com.hsedu.generic;

import java.util.ArrayList;

public class generic02 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("tom",12));
        dogs.add(new Dog("aom",15));
        dogs.add(new Dog("vom",14));
        for (Object o :dogs) {
            Dog d=(Dog) o;
            System.out.println(d.getName() + d.getAge());
        }
    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
