package com.hsedu.single_;

/**
 * ����ģʽ����ʽ
 */
public class CatS {
    private String name;
    private static CatS cat;// δ���ù�����
    private static int n1 = 100;//

    private CatS(String name) {
        System.out.println("���������");
        this.name = name;
    }

    public static CatS getInstance() {
        if (cat == null) {
            cat = new CatS("moo");// ��������
        }
        return cat;
    }

    public void setName(String name) {
        this.name = name;
    }
}
