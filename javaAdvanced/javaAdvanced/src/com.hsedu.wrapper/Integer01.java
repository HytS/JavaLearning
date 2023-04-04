package com.hsedu.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        // 手动装箱 int-->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer2 = Integer.valueOf(n1);

        // 手动拆箱 integer-->int
        integer.intValue();

        // 自动装箱
        int n2 = 200;
        Integer integer3 = n2;

        // 自动拆箱
        int n3 = integer3;
    }
}
