public class WrapperExerciese02 {
    public static void main(String[] args) {

    }

    public void method() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        // ����ıȽ� false
        System.out.println(i == j);

        Integer m = 1;// �ײ�װ�� Integer.valueOf(1)
        Integer n = 2;
        // �����Χ��-128-127ֱ�ӷ��أ������new Integer(xx)
        System.out.println(m == n);// T
        /*
         * public static Integer valueOf(int i) {
         * if (i >= IntegerCache.low && i <= IntegerCache.high)
         * return IntegerCache.cache[i + (-IntegerCache.low)];
         * return new Integer(i);
         * }
         * fftfftf
         */

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);// F
    }
}
