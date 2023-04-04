package com.hsedu.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        // GirlFirend xh=new
        GirlFirend girlFirend = GirlFirend.getInstance();
        System.out.println(girlFirend);


    }
}

class GirlFirend {
    private String name;

    /**
     * ����ģʽ����ʽ
     * 1��˽�л�������
     * 2�������д�������static
     * 3�����Ⱪ¶һ����������getInstance
     */

    // 2�� ����һ������
    private static GirlFirend gf = new GirlFirend("gong");

    // 1��˽�л�������
    private GirlFirend(String name) {
        this.name = name;
    }

    // 3����¶һ����������
    public static GirlFirend getInstance() {
        return gf;

    }
}

