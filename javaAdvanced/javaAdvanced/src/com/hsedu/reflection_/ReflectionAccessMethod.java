package com.hsedu.reflection_;

import java.lang.reflect.Method;

public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception{
        Class<?> mCls= Class.forName("com.hsedu.reflection_.Boss");
        Object o = mCls.newInstance();
//        Method hi = mCls.getMethod("hi", String.class);
        Method hi = mCls.getDeclaredMethod("hi",String.class );
        hi.invoke(o,"hss hi");

        Method say = mCls.getDeclaredMethod("say", String.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o,"hs"));
        //�����У���������з���ֵ��ͬ�ⷵ��Object�������������ͺͷ�������ķ�������һ��
    }
}

class Boss{
    public int age;
    private static String name;
    public Boss(){

    }
    public void hi(String name){
        System.out.println("hi");
    }
    private static String say(String name){
        return name+" ";
    }
}