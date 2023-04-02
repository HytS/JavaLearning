package com.hsedu.reflection_;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;
        Class<float[]> cls3 = float[].class;
        Class<float[][]> cls4 = float[][].class;
        Class<Thread.State> cls5 = Thread.State.class;//枚举
        Class<Long> cls6 = long.class;
        Class<Void> cls7 = void.class;
        Class<Class> cls8 = Class.class;
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);



    }
}
