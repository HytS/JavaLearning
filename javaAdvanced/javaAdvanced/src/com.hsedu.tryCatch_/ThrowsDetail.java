import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) {

    }

    public void f1() throws ArithmeticException {
        // 默认throws处理
    }

    public static void f2() throws FileNotFoundException {
        FileInputStream fie = new FileInputStream("d://aa.txt");
    }

    public static void f3() throws FileNotFoundException {
        f2();
        // 必须处理此异常，因为f2抛出的是编译异常
    }

    public static void f4() {
        // f5()抛出的是运行异常,在java中，并不要求程序员显式处理
        // 因为有默认处理机制
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