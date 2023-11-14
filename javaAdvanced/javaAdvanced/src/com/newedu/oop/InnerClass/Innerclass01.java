package com.newedu.oop.InnerClass;

public class Innerclass01 {
    public static void main(String[] args) {
        //匿名内部类的实现
        new X().fun1();
//        System.out.println();
    }
}
interface A{
    public void printInfo() ;	//
}
class B implements A{	// 实现接口
    public void printInfo(){
        System.out.println("Hello World!!!") ;
    }
};
class X {
    public void fun1(){
        this.fun2(new B()) ;
    }
    public void fun2(A a){
        a.printInfo() ;
    }
};