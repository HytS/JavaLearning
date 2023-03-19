public class WrapperExerciese01 {
    public static void main(String[] args) {
        // 三元运算符是一个整体，需要提升精度
        Object obj1 = true ? new Integer(1) : new Double(2);
        System.out.println(obj1);// 1.0

        Double d = 100d;// 自动装箱 Double.valueOf(100d)

        Object obj2;
        if (true) {
            obj2 = new Integer(1);
        } else {
            obj2 = new Double(2);
        }
        System.out.println(obj2);// 1
    }
}
