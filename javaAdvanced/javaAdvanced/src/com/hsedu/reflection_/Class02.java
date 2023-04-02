package com.hsedu.reflection_;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.hsedu.Car");

        System.out.println(cls);//��ʾcls�������Ǹ����Class����
        System.out.println(cls.getClasses());//���cls��������
        //��ȡ����
        System.out.println(cls.getPackage().getName());
        //�õ�ȫ����
        System.out.println(cls.getName());
        //��������ʵ��
        Object o = cls.newInstance();
        System.out.println(o);

        Field no = cls.getField("no");
        System.out.println(no);
        System.out.println(no.get(o));
        //ͨ�����丳ֵ
        no.set(o,10000);

        System.out.println("=====�����ֶ�����=====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }
}
