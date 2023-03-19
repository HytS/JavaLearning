import Outer08.Inner08;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        // 外部其他类访问内部类
        // Outer08.new Inner08();相当于把new Inner08()当作outer08的一个成员
        Outer08.Inner08 inner08 = Outer08.new Inner08();
        // 在外部类里编写一个方法，可以返回Inner08的对象
        Outer08.Inner08 gInner08 = outer08.getInner08instance();

        // Outer08 outer08 = new Outer08();
        // 外部其他类访问内部类需要创建对象
        outer08.say();
        // 外部其他类访问内部类方式一
        Outer08 outer082 = new Outer08();
        Inner08 inner081 = outer08.new Inner08();

        // 方式2在外部类中写一个方法，可以返回Inner08对象
        Outer08.Inner08 inner082 = outer08.getInnerInstance();

    }
}

class Outer08 {
    private int age = 10;
    public String name;

    // 可以添加任何修饰符
    final class Inner08 {// 成员内部类是定义在外部类的成员位置
        int age = 100;

        public void say() {
            System.out.println("Outer's age=" + age);
            // 可以直接访问外部类的所有成员
            System.out.println(name);
            // 当内部类和外部类有成员重名时；
            // 内部类仍旧想访问外部类
            System.out.println(Outer08.this.age);
        }

        public Inner08 getInner08instance() {
            return new Inner08();
        }

    }

    public Inner08 getInnerInstance() {
        return new Inner08();
    }

    public void t1() {
        Inner08 inner08 = new Inner08();
        // 外部类访问内部类要创建对象
        inner08.say();

    }
}
