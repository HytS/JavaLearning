package com.hsedu.InnerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer021 outer02 = new Outer021();
        outer02.hello();
        // �ⲿ�������޷����ʾֲ��ڲ��࣬��Ϊ�ֲ��ڲ����λ���Ǿֲ�����
        //System.out.println(Outer021.this.num);
    }
}

class Outer021 {
    private int num = 1;
    private String name = "hello";

    private void say() {
        System.out.println("hello");
        // System.out.println();

    }

    // �ⲿ��ľֲ�λ����
    public void hello() {
        // ������ӷ������η������Լ�final�����뱻�̳У�
        class Inner02 {
            // �ⲿ����ڲ����Ա����ʱ�����ͽ�ԭ��
            int num = 12;

            public void hi() {
                // �ֲ��ڲ�����Է����ⲿ��ĳ�Ա��ֱ�ӷ���
                System.out.println(num);
                // Outer02.this.num �����ⲿ��ĳ�Ա
                // Outer02.this.hello()
                // Outer02.this ���ʾ����ⲿ���һ������
                // ���Ǹ��������hello(),�Ǹ��������Outer02.this
                System.out.println(Outer021.this.name);
                ;
                say();
            }

        }
        // �ⲿ������ڲ��࣬�������������ڣ�����������飩
        // �ⲿ���ڷ����У��ȴ�������Ȼ����÷���
        Inner02 inn = new Inner02();
        inn.hi();

    }
}