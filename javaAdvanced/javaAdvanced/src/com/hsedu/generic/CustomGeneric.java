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
    //���鲻�ܳ�ʼ����������newʱ�޷�ȷ��T������
    T[] t1;
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    //��Ϊ��̬��������صģ��������ʱ������û�����������̬����������ʹ�÷��ͣ�jvm�޷���ʼ��
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

