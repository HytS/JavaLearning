public class Override {
    public static void main(String[] args) {

    }
}

class Son extends Father {
    @Override
    // 有没有@override都是重写
    // 如果没写override，编译器就会检查该方法是否真的重写了父类的方法
    // 如果的确重写了，则编译通过，如果没有重写，编译报错
    public void fly() {
        System.out.println("son fly");
    }
}

class Father {
    public void fly() {
        System.out.println("flying");
    }
}
