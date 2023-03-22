package com.hsedu.final_;

public class final01 {
    public static void main(String[] args) {

    }
}

 class Afinal {
    // final修饰的类，不希望被继承
    public final void say() {
        System.out.println("hello");
    }
}

class B extends Afinal {
    // final修饰属性，不希望属性值被修改
    public final int N = 100010;

    // final修饰的父类方法无法被
    // public void say() {
    // System.out.println("Bhello");
    // }
}

class C {
    // 局部变量不希望被修改
    public void hello() {
        final int num = 100;
        // num=200;
        System.out.println(num);
    }

}
