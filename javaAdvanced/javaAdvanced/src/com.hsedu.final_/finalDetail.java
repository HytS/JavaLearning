package com.hsedu.final_;

public class finalDetail {
    public static void main(String[] args) {
        EE ee = new EE();
        ee.name();// 可以使用继承父类的final方法
    }
}

class AA {
    // 定义时赋值
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {
        // 构造器赋值
        TAX_RATE2 = 0.08;
    }

    {// 代码块赋值
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
    // num1 = 100; //不能在构造器中赋值
    // }
}

final class CC {
    // final不能继承，可以实例化对象

}

class DD {
    // 类不是final，但含有final方法，该方法不能被重写，可以被继承
    public final void name() {
        System.out.println("name method");
    }
}

class EE extends DD {

}
