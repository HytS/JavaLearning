import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) {

    }

    public void f1() throws ArithmeticException {
        // Ĭ��throws����
    }

    public static void f2() throws FileNotFoundException {
        FileInputStream fie = new FileInputStream("d://aa.txt");
    }

    public static void f3() throws FileNotFoundException {
        f2();
        // ���봦����쳣����Ϊf2�׳����Ǳ����쳣
    }

    public static void f4() {
        // f5()�׳����������쳣,��java�У�����Ҫ�����Ա��ʽ����
        // ��Ϊ��Ĭ�ϴ������
        f5();
    }

    public static void f5() throws ArithmeticException {

    }
}

class AA {
    public void ssay() throws RuntimeException {
        System.out.println("dad method");
    }
}

class CC extends AA {
    @Override
    public void ssay() throws NullPointerException {
        System.out.println("son rewrite ssay()");
    }
}