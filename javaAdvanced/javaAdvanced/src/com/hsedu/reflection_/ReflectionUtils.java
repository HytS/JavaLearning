package com.hsedu.reflection_;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) throws Exception{
        Class<?> personCls = Class.forName("com.hsedu.reflection_.Person");
        System.out.println(personCls.getName());
        System.out.println(personCls.getSimpleName());
        Field[] fields = personCls.getFields();
        for (Field field :fields) {
            System.out.println("本类及父类属性="+field.getName());
        }
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性="+declaredField.getName());
        }
        //返回所有public修饰的方法包含本类和父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类所有的方法="+method.getName());
        }
        //返回本列中所有的方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //获取所有public修饰的构造器，包括本类和父类
        Constructor<?>[] constructors = personCls.getConstructors();
        //获取本类所有的构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        //返回包信息
        System.out.println(personCls.getPackage());
        //返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
        //返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        //返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println();


    }


}
class Person{
    public String hobby;
    public String name;
}
