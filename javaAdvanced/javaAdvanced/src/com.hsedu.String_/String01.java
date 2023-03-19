public class String01 {
    public static void main(String[] args) {
        String a = "hsedu";
        String b = new String("hsedu");
        System.out.println(a.equals(b));// T
        System.out.println(a == b);// F
        System.out.println(a == b.intern());// T
        System.out.println(b == b.intern());// F

        // tt tt
    }
}
