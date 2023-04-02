package com.hsedu.reflection_;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\gitLearning\\JavaLearning\\javaAdvanced\\javaAdvanced\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method1 = cls.getMethod(methodName);
        method1.invoke(o);

        //getField ���ܵõ�˽�е�����
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));//���䣺��Ա��������.get(����)

        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

    }
}
