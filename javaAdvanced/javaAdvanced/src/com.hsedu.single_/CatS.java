package com.hsedu.single_;

/**
 * 单例模式懒汉式
 */
public class CatS {
    private String name;
    private static CatS cat;// 未调用构造器
    private static int n1 = 100;//

    private CatS(String name) {
        System.out.println("构造器输出");
        this.name = name;
    }

    public static CatS getInstance() {
        if (cat == null) {
            cat = new CatS("moo");// 创建对象
        }
        return cat;
    }

    public void setName(String name) {
        this.name = name;
    }
}
