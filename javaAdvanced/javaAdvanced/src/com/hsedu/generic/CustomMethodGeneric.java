package com.hsedu.generic;

public class CustomMethodGeneric {
    public static void main(String[] args) {
        AGen a=new AGen();
        a.sayhi("tom",12);
        System.out.println(a);
    }
}
class AGen{
    public <T,R> void sayhi(T t,R r){

    }

}

class BGen<U,M>{
    public <U,M> void say(U u,M m){

    }
}
