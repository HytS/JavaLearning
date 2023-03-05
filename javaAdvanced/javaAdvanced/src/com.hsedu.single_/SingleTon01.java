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
     * 单例模式
     * 1、私有化构造器
     * 2、在类中创建对象
     * 3、getInstance
     */

    private static GirlFirend gf = new GirlFirend("gong");

    private GirlFirend(String name) {
        this.name = name;
    }

    public static GirlFirend getInstance() {
        return gf;

    }
}
