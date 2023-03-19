package com.hsedu.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat instacnce = Cat.getInstance();
    }
}

/**
 * 单例模式懒汉式
 */
public class Cat {
    private String name;
    private static Cat cat;// 未调用构造器
    private static int n1 = 100;//

    private Cat(String name) {
        System.out.println("构造器输出");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("moo");// 创建对象
        }
        return cat;
    }

    public void setName(String name) {
        this.name = name;
    }
}