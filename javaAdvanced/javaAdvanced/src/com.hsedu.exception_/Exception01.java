public class Exception01 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;
        // int res = n1 / n2;// 程序会抛出异常
        System.out.println();
        // 如果程序与认为一段代码可能出现异常问题可以使用try-catch异常处理机制解决
        try {
            int res = n1 / n2;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());// 输出异常信息
        }
    }
}
