package com.hsedu.InnerClass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
        // �ⲿ�������޷����������ڲ��࣬��Ϊ��λ�������ڲ����Ǿֲ�����
        // System.out.println(Outer04.this.name);
    }
}

class Outer04 {// �ⲿ��
    private int n1 = 10;
    private String name = "hello";

    public void method() {
        // ���ڽӿڵ������ڲ���
        // �ײ����� ���� Outer04$1
        // tiger �������� A������������ϵͳ����������ڲ���Outer04$1
        // jdk�ײ��ڴ��������ڲ���Outer04$1�����̴���Outer04$1ʵ��
        // ���Ұѵ�ַ���ظ�tiger
        // �����ڲ���ʹ��һ�ξͲ�����ʹ��
        A tiger = new A() {
            private int n1 = 20;

            public void cry() {
                // �����ڲ�������ⲿ���Ա��ֱ�ӷ���
                System.out.println(name);
                // �ⲿ��������ڲ����Ա����ʱ�����վͽ�ԭ��
                // �����ⲿ���Ա
                System.out.println(Outer04.this.name);
                System.out.println("tiger cry");
            }
        };
        // getClass���Ի�ö������������
        System.out.println(tiger.getClass());

        // ��������Outer04$2
        // jack����������
        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("�����ڲ�����дtest����");
            }
        };

        father.test();

        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat bone");
            }
        };
        animal.eat();
    }
}

interface A {// �ӿ�
    public void cry();
}

class Father {// ��
    public Father(String name) {
        System.out.println("name=" + name);
    }

    public void test() {

    }
}

abstract class Animal {
    public void eat() {

    }
}
