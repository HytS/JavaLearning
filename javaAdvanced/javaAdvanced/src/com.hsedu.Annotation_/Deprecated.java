public class Deprecated {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
    }
}

/*
 * @Deprecated 修饰某个元素，表示该元素已经过时
 * 不推荐使用，但是仍然可以使用
 */
@Deprecated
class A {
    @Deprecated
    public int n1 = 20;

    public void hi() {

    }
}