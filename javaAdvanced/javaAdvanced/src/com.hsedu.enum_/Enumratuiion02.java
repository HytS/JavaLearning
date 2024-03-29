package com.hsedu.enum_;

public class Enumratuiion02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

enum Season2 {

    // 使用enum实现枚举类
    // 使用关键字enum代替class
    // 常量名(实参列表)
    // 如果有多个常量，使用，号间隔
    // 如果使用enum实现枚举，要求将定义常量对象写在前面
    SPRING("spring", "warm"), // 常量对象
    WINTER("winter", "cool");

    private String name;
    private String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
