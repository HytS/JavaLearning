package com.hsedu.final_;

public class finalDetail {
    public static void main(String[] args) {
        EE ee = new EE();
        ee.name();// ����ʹ�ü̳и����final����
    }
}

class AA {
    // ����ʱ��ֵ
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {
        // ��������ֵ
        TAX_RATE2 = 0.08;
    }

    {// ����鸳ֵ
        TAX_RATE3 = 0.21;
    }
}

class BB {
    public static final int num = 100;
    public static final int num1;
    static {
        num1 = 200;
    }

    // public BB() {
    // num1 = 100; //�����ڹ������и�ֵ
    // }
}

final class CC {
    // final���ܼ̳У�����ʵ��������

}

class DD {
    // �಻��final��������final�������÷������ܱ���д�����Ա��̳�
    public final void name() {
        System.out.println("name method");
    }
}

class EE extends DD {

}
