public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {// 外部类
    private int n1 = 10;

    public void method() {
        // 基于接口的匿名内部类
        // 底层会分配 类名 Outer04$1
        // tiger 编译类型 A；运行类型是系统分配的匿名内部类Outer04$1
        // jdk底层在创建匿名内部类Outer04$1，立刻创建Outer04$1实例
        // 并且把地址返回给tiger
        // 匿名内部类使用一次就不能再使用
        A tiger = new A() {
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        // getClass可以获得对象的运行类型
        System.out.println(tiger.getClass());

        // 运行类型Outer04$2
        // jack传给构造器
        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("匿名内部类重写test方法");
            }
        };

        father.test();

        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("eat bone");
            }
        };
        animal.eat();
    }
}

interface A {// 接口
    public void cry();
}

class Father {// 类
    public Father(String name) {
        System.out.println("name=" + name);
    }

    public void test() {

    }
}

abstract class Animal {
    public void eat() {

    }
}
