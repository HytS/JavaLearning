package com.hsedu.reflection_;

import com.hsedu.Car;
import com.hsedu.Cat;

public class Class03 {
    public static void main(String[] args) throws  Exception{
        Class<?> cls = Class.forName("com.hsedu.Car");
        System.out.println(cls);

        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass("com.hsedu.Car");
        System.out.println(cls4);

        //������������Ҳ�ܵõ�Class����
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        //�����������Ͷ�Ӧ�İ�װ�����ͨ��.TYPE�õ�Class��
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

    }
}
