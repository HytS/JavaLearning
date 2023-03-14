public class anonymousInnerClassDetail {
    public static void main(String[] args) {

    }
}

class Outer05 {
    private int n1 = 2;

    public void f1() {
        Person p1 = new Person() {
            int n1 = 100;

            // 匿名内部类重写hi
            @Override
            public void hi() {
                System.out.println("rewrite hi method");
                System.out.println("n1=" + n1 + "Outer05 ni" + Outer05.this.n1);
            }
        };

        p1.hi();// 动态绑定，运行类型是Outer05$1
        // *******
        // 也可以直接调用,因为匿名内部类本身也是返回对象
        // class 匿名内部类 extends Person{}
        new Person() {
            @Override
            public void hi() {
                System.out.println("hi again");
            }
        }.hi();
    }
}

class Person {
    public void hi() {
        System.out.println("hi");
    }
}
