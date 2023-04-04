package com.hspedu.static_;

/**
 * Child
 */
public class Child {
    private String name;

    //定义一个静态变量，
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public static void setCount(int count) {
        Child.count = count;
    }

    public static int getCount() {
        return count;
    }

    public void join() {
        System.out.println("join us");
    }

}
