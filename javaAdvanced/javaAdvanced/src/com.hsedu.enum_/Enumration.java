package com.hsedu.enum_;

public class Enumration {
    public static void main(String[] args) {
        System.out.println(Season.class);
    }
}

class Season {
    private String name;
    private String desc;

    public static Season SPRING = new Season("spring", "warm");

    // �Զ���ö��
    // ��������˽�л�
    // ȥ��set��������ֹ���Ա��޸�
    // ��Season�ڲ���ֱ�Ӵ����̶��Ķ���
    // �Ż������final���η�
    private Season(
            String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

}