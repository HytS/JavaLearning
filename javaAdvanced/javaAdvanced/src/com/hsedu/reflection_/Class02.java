package com.hsedu.reflection_;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.hsedu.Car");

        System.out.println(cls);//显示cls对象，是那个类的Class对象
        System.out.println(cls.getClasses());//输出cls运行类型
        //获取包名
        System.out.println(cls.getPackage().getName());
        //得到全类名
        System.out.println(cls.getName());
        //创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);

        Field no = cls.getField("no");
        System.out.println(no);
        System.out.println(no.get(o));
        //通过反射赋值
        no.set(o,10000);

        System.out.println("=====所有字段属性=====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }
}
