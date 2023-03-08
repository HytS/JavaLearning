public class abstractDetail {
    public static void main(String[] args) {
        // 抽象类不能被实例化
        // new A();
    }
}

abstract class A {
    public void say() {
        System.out.println("hello");
    }
}

class B {
    // 一旦类中包含abstract方法，类就要声明为abstract
    // public abstract void name();

}