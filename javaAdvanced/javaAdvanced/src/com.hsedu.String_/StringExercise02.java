public class StringExercise02 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.change(t1.str, t1.ch);
        System.out.println(t1.str + "and");
        System.out.println(t1.ch);
    }
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = { 'j', 'a', 'v', 'a' };

    public void change(String str, char[] ch) {
        str = "java";
        ch[0] = 'h';
    }
}
