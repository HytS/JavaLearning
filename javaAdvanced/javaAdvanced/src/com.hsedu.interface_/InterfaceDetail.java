public class InterfaceDetail {
    public static void main(String[] args) {
        // 可以通过接口名访问就是static的
        System.out.println(IB.a);

        // IB.a=2; final不允许改变
    }
}

interface IB {
    int a = 1;// public 如何证明

    void hi();
}

interface IC {
    void say();
}

public interface ID extends IB, IC {
    // 接口的修饰符只能是public和默认
}

class Pig implements IB, IC {
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}
