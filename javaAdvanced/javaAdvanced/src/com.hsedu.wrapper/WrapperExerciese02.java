public class WrapperExerciese02 {
    public static void main(String[] args) {

    }

    public void method() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        // 对象的比较 false
        System.out.println(i == j);

        Integer m = 1;// 底层装箱 Integer.valueOf(1)
        Integer n = 2;
        // 如果范围在-128-127直接返回，否则就new Integer(xx)
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
