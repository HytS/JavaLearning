package com.hsedu.interface_;

public class Interfacce01 {
    public static void main(String[] args) {
//        Phone p1 = new Phone();
//        Computer computer = new Computer();
//        computer.work(p1);

        // A a = new A(); 接口不能实例化

    }
}

interface A {
    int a = 1;// public final static int a=1;

    public void say();
}

interface C {
    public void say();
}

class B implements A, C {
    @Override
    public void say() {
        System.out.println("实现接口A的方法体");
    }
}