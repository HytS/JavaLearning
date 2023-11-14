package com.newedu.oop.InnerClass;

public class InnerclassExd {
    public static void main(String[] args) {
        A3.B3 b3= new X2().new Y();
        b3.printB();
    }
}

abstract class A3{
    public abstract void print();
    interface B3{
        void printB();
    }
}
class X2 extends A3{
    @Override
    public void print() {
        System.out.println("x2  µœ÷open()");
    }
    class Y implements B3{

        @Override
        public void printB() {
            System.out.println("class Y impl printB()");
        }
    }
}
