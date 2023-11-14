package com.newedu.oop.InnerClass;

public class Innerclass02 {
    public static void main(String[] args) {

    }
}
interface A1{
    void print();
}

class X1{
    void fun1(){this.fun2(new A1(){
        @Override
        public void print() {
            System.out.println("hello");
        }
    });}
    void fun2(A1 a1){
        a1.print();
    }
}
