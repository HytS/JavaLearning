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
            System.out.println("���༰��������="+field.getName());
        }
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("������������="+declaredField.getName());
        }
        //��������public���εķ�����������͸����
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("�������еķ���="+method.getName());
        }
        //���ر��������еķ���
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        //��ȡ����public���εĹ���������������͸���
        Constructor<?>[] constructors = personCls.getConstructors();
        //��ȡ�������еĹ�����
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        //���ذ���Ϣ
        System.out.println(personCls.getPackage());
        //���ظ�����Ϣ
        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
        //���ؽӿ���Ϣ
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        //����ע����Ϣ
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
