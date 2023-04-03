package com.hsedu.reflection_;

import com.hsedu.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflectionQuestion_ {
    public static void main(String[] args) throws Exception{
        Cat cat = new Cat();
        cat.hi();

        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\gitLearning\\JavaLearning\\javaAdvanced\\javaAdvanced\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath="+classfullpath);

        //加载类，返回Class类型的对象cls
        Class<?> cls = Class.forName(classfullpath);
        //通过cls得到你加载的类com.hsedu.Cat的对象实例
        Object o = cls.newInstance();

        //通过cls得到加载的类Cat的methodName的方法对象
        Method method = cls.getMethod(methodName);
        System.out.println("======================");
        //通过方法对象来实现调用方法
        method.invoke(o);
    }
}
