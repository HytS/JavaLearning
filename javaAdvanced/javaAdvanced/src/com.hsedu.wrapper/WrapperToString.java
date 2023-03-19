public class WrapperToString {
    public static void main(String[] args) {
        // 包装类Integer-->String
        Integer n1 = 100;// 自动装箱
        // 方式1
        String str = n1.toString();
        // 方式2
        String str2 = n1 + "";
        // 方式3
        String str3 = String.valueOf(n1);

        // String -->包装类
        String str4 = "123";
        Integer n2 = Integer.parseInt(str4);
        Integer n3 = new Integer(str4);
    }
}
