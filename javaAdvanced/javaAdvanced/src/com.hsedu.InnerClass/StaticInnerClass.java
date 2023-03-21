package com.hsedu.InnerClass;



public class StaticInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();

        // �ⲿ��������ʾ�̬�ڲ���
        // ��̬�ڲ������ͨ������ֱ�ӷ���
        Outer02.Inner10 inner10 = new Outer02.Inner10();
        inner10.say();

        // ��дһ�����������ؾ�̬�ڲ���Ķ���ʵ��
        Outer02.Inner10 inner102 = outer02.getInnerInstance();
        inner102.say();

        Outer02.Inner10 inner103 = Outer02.getInnerInstance_();
        inner103.say();

    }
}

class Outer02 {
    private int n1 = 10;
    private static String name = "uzi";

    private static void cry() {
        Inner10 inner10 = new Inner10();
        // �ⲿ����ʾ�̬��Ա��Ҫ��������
//        System.out.println(inner10.say());
        inner10.say();
    }


    // Inner10���Ǿ�̬�ڲ���
    public static class Inner10 {
        private static String name = "aaa";

        public void say() {
            // System.out.println(n1);���ܷ��ʷǾ�̬��Ա
            System.out.println(name);
            cry();
            // �ڲ�������ⲿ���Ա
            System.out.println(Outer02.name);
        }
    }

    public Inner10 getInnerInstance() {
        return new Inner10();
    }

    public static Inner10 getInnerInstance_() {
        return new Inner10();
    }

    public void m1() {
        // �ⲿ������ڲ��࣬��������
        Inner10 inner10 = new Inner10();
        inner10.say();

        Outer02 outer02 = new Outer02();
        outer02.cry();
    }
}
