package com.hsedu.generic;

public class generic03 {
    public static void main(String[] args) {
        //E�ľ������������ڶ���Person����ʱָ�������ڱ����ڼ䣬��ȷ��E��ʲô����
        Person<String> person = new Person<String>("adis");
        System.out.println(person);
        Person<Integer> person1 = new Person<Integer>(123);
        System.out.println(person1);
    }
}
class Person<E>{
    //E��ʾs�����ͣ������������ڶ���Person�����ʱ��ָ�������ڱ����ڼ䣬��ȷ��E��ʲô����
  E s;
  //����
    public Person(E e) {
        this.s=e;
    }
    //��������
    public E say(){
        return s;
    }
}
