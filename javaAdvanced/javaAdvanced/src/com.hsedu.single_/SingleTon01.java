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
     * ����ģʽ
     * 1��˽�л�������
     * 2�������д�������
     * 3��getInstance
     */

    private static GirlFirend gf = new GirlFirend("gong");

    private GirlFirend(String name) {
        this.name = name;
    }

    public static GirlFirend getInstance() {
        return gf;

    }
}
