public class InnerClass01 {// 外部类
    public static void main(String[] args) {

    }
}

class OutterClass {
    int n1 = 100;

    public OutterClass(int n1) {// 构造器
        this.n1 = n1;
    }

    public void say() {// 方法

    }

    {
        // 代码块
    }

    class InnerClass {
        // 内部类
    }
}
