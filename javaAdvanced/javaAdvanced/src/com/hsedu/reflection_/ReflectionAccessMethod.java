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
        //反射中，如果方法有返回值，同意返回Object，但是运行类型和方法定义的返回类型一致
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