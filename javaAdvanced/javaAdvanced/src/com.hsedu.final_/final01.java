package com.hsedu.final_;

public class final01 {
    public static void main(String[] args) {

    }
}

 class Afinal {
    // final���ε��࣬��ϣ�����̳�
    public final void say() {
        System.out.println("hello");
    }
}

class B extends Afinal {
    // final�������ԣ���ϣ������ֵ���޸�
    public final int N = 100010;

    // final���εĸ��෽���޷���
    // public void say() {
    // System.out.println("Bhello");
    // }
}

class C {
    // �ֲ�������ϣ�����޸�
    public void hello() {
        final int num = 100;
        // num=200;
        System.out.println(num);
    }

}
