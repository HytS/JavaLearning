public class MathMethod {
    public static void main(String[] args) {
        // ����2-7�������
        for (int i = 0; i < 100; i++) {
            // random()���ص�����0-1
            System.out.println((int) (2 + Math.random() * (7 - 2 + 1)));
        }
    }
}
