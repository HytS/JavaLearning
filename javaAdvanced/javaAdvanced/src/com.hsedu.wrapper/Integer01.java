package com.hsedu.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        // �ֶ�װ�� int-->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer2 = Integer.valueOf(n1);

        // �ֶ����� integer-->int
        integer.intValue();

        // �Զ�װ��
        int n2 = 200;
        Integer integer3 = n2;

        // �Զ�����
        int n3 = integer3;
    }
}
