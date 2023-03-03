package com.hspedu.static_;

public class staticDetail {
    public static void main(String[] args) {
        A a = new A();
        
        // System.out.println(A.n1);
        System.out.println(A.n2);
        System.out.println(C.adress);
    }
}
class A{
    public int n1=100;
    public static int n2=200;
}

class C{
    public static String adress="beijing";
}