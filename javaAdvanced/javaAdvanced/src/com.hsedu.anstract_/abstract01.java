package com.hsedu.anstract_;

public class abstract01 {
    public static void main(String[] args) {

        //抽象类无法初始化
//        Animal animal = new Animal("tom");

    }
}

 abstract class Animal {

    private String name;

    Animal(String name) {
        this.name = name;
    }

    /*
     * 抽象方法就是没有实现的方法，即没有方法体
     * 当一个类中存在抽象方法时，需要将该类声明为abstract类
     * 一般来说，抽象类会被继承，有其子类来实现抽象方法
     */

    public abstract void eat();

}

class Cat extends Animal {
    public Cat() {
        super("tomn");
    }

    @Override
    public void eat() {
        System.out.println("抽象类 eat()被实现");
    }
}

class Dog {
    // 类包含了抽象方法就必须声明为抽象类
    // abstract public void say(){
    // System.out.println("hello");
    // }
}