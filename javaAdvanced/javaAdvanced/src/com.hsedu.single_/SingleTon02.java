package com.hsedu.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat instacnce = Cat.getInstance();
    }
}

/**
 * ����ģʽ����ʽ
 */
public class Cat {
    private String name;
    private static Cat cat;// δ���ù�����
    private static int n1 = 100;//

    private Cat(String name) {
        System.out.println("���������");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("moo");// ��������
        }
        return cat;
    }

    public void setName(String name) {
        this.name = name;
    }
}