package com.hsedu.anstract_;

public class abstract01 {
    public static void main(String[] args) {

        //�������޷���ʼ��
//        Animal animal = new Animal("tom");

    }
}

 abstract class Animal {

    private String name;

    Animal(String name) {
        this.name = name;
    }

    /*
     * ���󷽷�����û��ʵ�ֵķ�������û�з�����
     * ��һ�����д��ڳ��󷽷�ʱ����Ҫ����������Ϊabstract��
     * һ����˵��������ᱻ�̳У�����������ʵ�ֳ��󷽷�
     */

    public abstract void eat();

}

class Cat extends Animal {
    public Cat() {
        super("tomn");
    }

    @Override
    public void eat() {
        System.out.println("������ eat()��ʵ��");
    }
}

class Dog {
    // ������˳��󷽷��ͱ�������Ϊ������
    // abstract public void say(){
    // System.out.println("hello");
    // }
}