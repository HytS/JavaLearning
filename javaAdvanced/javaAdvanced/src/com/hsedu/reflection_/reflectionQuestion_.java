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

        //�����࣬����Class���͵Ķ���cls
        Class<?> cls = Class.forName(classfullpath);
        //ͨ��cls�õ�����ص���com.hsedu.Cat�Ķ���ʵ��
        Object o = cls.newInstance();

        //ͨ��cls�õ����ص���Cat��methodName�ķ�������
        Method method = cls.getMethod(methodName);
        System.out.println("======================");
        //ͨ������������ʵ�ֵ��÷���
        method.invoke(o);
    }
}
