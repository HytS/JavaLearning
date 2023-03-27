package com.hsedu.generic;

public class CustomGeneric {
    public static void main(String[] args) {

    }
}
class Tiger<T,R,M>{
    private String name;
    T t;
    R r;
    M m;
    //数组不能初始化，数组在new时无法确定T的类型
    T[] t1;
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    //因为静态和类是相关的，在类加载时，对象还没创建，如果静态方法和属性使用泛型，jvm无法初始化
//    public static void say(M m){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}

