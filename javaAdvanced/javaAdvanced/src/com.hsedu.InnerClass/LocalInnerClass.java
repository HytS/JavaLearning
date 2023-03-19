public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.hello();
        // 外部其他类无法访问局部内部类，因为局部内部类地位上是局部变量
        System.out.println(outer02.this.num);
    }
}

class Outer02 {
    private int num = 1;
    private String name = "hello";

    private void say() {
        System.out.println("hello");
        // System.out.println();

    }

    // 外部类的局部位置上
    public void hello() {
        // 不能添加访问修饰符，可以加final（不想被继承）
        class Inner02 {
            // 外部类和内部类成员重名时，按就近原则
            int num = 12;

            public void hi() {
                // 局部内部类可以访问外部类的成员：直接访问
                System.out.println(num);
                // Outer02.this.num 访问外部类的成员
                // Outer02.this.hello()
                // Outer02.this 本质就是外部类的一个对象，
                // 即那个对象调用hello(),那个对象就是Outer02.this
                System.out.println(Outer02.this.name);
                ;
                say();
            }

        }
        // 外部类访问内部类，必须在作用域内（方法体或代码块）
        // 外部类在方法中，先创建对象然后调用方法
        Inner02 inn = new Inner02();
        inn.hi();

    }
}