public class MathMethod {
    public static void main(String[] args) {
        // 返回2-7的随机数
        for (int i = 0; i < 100; i++) {
            // random()返回的数是0-1
            System.out.println((int) (2 + Math.random() * (7 - 2 + 1)));
        }
    }
}
