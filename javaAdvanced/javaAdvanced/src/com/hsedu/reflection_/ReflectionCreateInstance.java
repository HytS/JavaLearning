package com.hsedu.reflection_;

import java.lang.reflect.Constructor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.hsedu.reflection_.ReflectionCreateInstance");
        Object o = aClass.newInstance();
        System.out.println(o);

        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("hs");
        System.out.println(o1);

//        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class,String.class);
//
//        declaredConstructor.setAccessible(true);
//        Object o2 = declaredConstructor.newInstance(100,"hs");
//        System.out.println(o2);

    }
}

class User{
    private int age=10;
    private String name="ss";

    public User(){}
    public User(String name){
        this.name=name;
    }
    private User(int age,String name){
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}