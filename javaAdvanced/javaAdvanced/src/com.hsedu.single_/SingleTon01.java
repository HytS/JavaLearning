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
     * 单例模式饿汉式
     * 1、私有化构造器
     * 2、在类中创建对象static
     * 3、向外暴露一个公共方法getInstance
     */

    // 2、 创建一个对象
    private static GirlFirend gf = new GirlFirend("gong");

    // 1、私有化构造器
    private GirlFirend(String name) {
        this.name = name;
    }

    // 3、暴露一个公共方法
    public static GirlFirend getInstance() {
        return gf;

    }
}

