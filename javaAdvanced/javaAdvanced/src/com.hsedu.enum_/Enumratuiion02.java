package com.hsedu.enum_;

public class Enumratuiion02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

enum Season2 {

    // ʹ��enumʵ��ö����
    // ʹ�ùؼ���enum����class
    // ������(ʵ���б�)
    // ����ж��������ʹ�ã��ż��
    // ���ʹ��enumʵ��ö�٣�Ҫ�󽫶��峣������д��ǰ��
    SPRING("spring", "warm"), // ��������
    WINTER("winter", "cool");

    private String name;
    private String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
