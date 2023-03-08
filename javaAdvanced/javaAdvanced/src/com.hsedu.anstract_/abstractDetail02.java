public class abstractDetail02 {
    public static void main(String[] args) {

    }
}

abstract class D {// 抽象类的本质还是类
    public int n1 = 200;
    public static String name = "hsedu";

    public void hi() {
        System.out.println("hi()");
    }

    public abstract void hello();
}

abstract class E extends D {

}