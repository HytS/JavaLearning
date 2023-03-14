public class CodeBlockDetail01 {
    public static void main(String[] args) throws Exception {
        System.out.println(DD.n1);
    }
}

class DD {
    public static int n1 = 99;
    static {
        System.out.println("dd的静态代码块被执行");
    };
    {
        System.out.println("dd的普通代码块被执行");
    }
}

class CC {
    // 静态属性初始化，静态属性和静态代码块按顺序执行
    public static int n1 = getN1();
    public int num = 20;
    private static int n2 = 200;
    static {

        System.out.println("CCd的静态代码块");

        System.out.println(n2);
        // System.out.println(num);静态属性代码块只能调用静态成员
    }

    public static int getN1() {
        System.out.println("getN1()被调用");
        return 100;
    }
}