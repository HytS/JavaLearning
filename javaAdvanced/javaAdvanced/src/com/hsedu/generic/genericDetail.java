package com.hsedu.generic;

import java.util.ArrayList;

public class genericDetail {
    public static void main(String[] args) {
        Pig<A> aPig = new Pig<A>(new A());
        Pig<A> aPig1 = new Pig<A>(new B());

        //�Ƽ�����д��
        ArrayList<Object> objects = new ArrayList<>();
        //Ĭ����Object
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