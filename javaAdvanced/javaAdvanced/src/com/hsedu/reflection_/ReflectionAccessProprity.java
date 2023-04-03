package com.hsedu.reflection_;

import java.lang.reflect.Field;

public class ReflectionAccessProprity {
    public static void main(String[] args) throws Exception{
        Class<?> stuClass = Class.forName("com.hsedu.reflection_.Student");
        Object o = stuClass.newInstance();
        System.out.println(o.getClass());

        Field age = stuClass.getField("age");
        age.set(o,88);
        System.out.println(o);
        System.out.println(age.get(o));

        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null,"hs");//因为name是static属性，因此o也可以写null
        System.out.println(o);//获得属性值
        System.out.println(name.get(o));
        System.out.println(name.get(null));
    }
}
class Student{
    public int age;
    private static String name;
    public Student(){}
}
