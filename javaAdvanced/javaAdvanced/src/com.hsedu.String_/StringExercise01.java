public class StringExercise01 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";
        // 1、先创立一个对象 StringBuilder sb=new StringBuilder();
        // 2、执行sb.append("hello") 3、sb.append("abc")
        // sb是在堆中，并且append是在原来字符串的基础上追加的
        // 4、String c=sb.toString()
        // 最后c指向堆中的对象(String)value[]->池中"helloabc"
        String c = a + b;// 一共有3个对象
    }
}
