package com.hsedu.generic;

public class generic03 {
    public static void main(String[] args) {
        //E的具体数据类型在定义Person对象时指定，即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("adis");
        System.out.println(person);
        Person<Integer> person1 = new Person<Integer>(123);
        System.out.println(person1);
    }
}
class Person<E>{
    //E表示s的类型，该数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型
  E s;
  //参数
    public Person(E e) {
        this.s=e;
    }
    //返回类型
    public E say(){
        return s;
    }
}
