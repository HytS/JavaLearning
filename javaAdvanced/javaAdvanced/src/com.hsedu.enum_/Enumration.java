package com.hsedu.enum_;

public class Enumration {
    public static void main(String[] args) {
        System.out.println(Season.class);
    }
}

class Season {
    private String name;
    private String desc;

    public static Season SPRING = new Season("spring", "warm");

    // 自定义枚举
    // 将构造器私有化
    // 去掉set方法，防止属性被修改
    // 再Season内部，直接创建固定的对象
    // 优化：添加final修饰符
    private Season(
            String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

}