package com.hsedu.generic;

import java.util.ArrayList;

public class genericDetail {
    public static void main(String[] args) {
        Pig<A> aPig = new Pig<A>(new A());
        Pig<A> aPig1 = new Pig<A>(new B());

        //推荐这种写法
        ArrayList<Object> objects = new ArrayList<>();
        //默认是Object
        ArrayList object1 = new ArrayList();

    }
}
class A{}
class B extends A{}

class Pig<E>{
    E e;

    public Pig(E e) {
        this.e = e;
    }
}