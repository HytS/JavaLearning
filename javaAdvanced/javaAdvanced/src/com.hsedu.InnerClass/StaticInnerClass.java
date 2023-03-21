package com.hsedu.InnerClass;



public class StaticInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();

        // 外部其他类访问静态内部类
        // 静态内部类可以通过类名直接访问
        Outer02.Inner10 inner10 = new Outer02.Inner10();
        inner10.say();

        // 编写一个方法，返回静态内部类的对象实例
        Outer02.Inner10 inner102 = outer02.getInnerInstance();
        inner102.say();

        Outer02.Inner10 inner103 = Outer02.getInnerInstance_();
        inner103.say();

    }
}

class Outer02 {
    private int n1 = 10;
    private static String name = "uzi";

    private static void cry() {
        Inner10 inner10 = new Inner10();
        // 外部类访问静态成员需要创建对象
//        System.out.println(inner10.say());
        inner10.say();
    }


    // Inner10就是静态内部类
    public static class Inner10 {
        private static String name = "aaa";

        public void say() {
            // System.out.println(n1);不能访问非静态成员
            System.out.println(name);
            cry();
            // 内部类访问外部类成员
            System.out.println(Outer02.name);
        }
    }

    public Inner10 getInnerInstance() {
        return new Inner10();
    }

    public static Inner10 getInnerInstance_() {
        return new Inner10();
    }

    public void m1() {
        // 外部类访问内部类，创建对象
        Inner10 inner10 = new Inner10();
        inner10.say();

        Outer02 outer02 = new Outer02();
        outer02.cry();
    }
}
