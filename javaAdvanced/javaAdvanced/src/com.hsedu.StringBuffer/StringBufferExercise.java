public class StringBufferExercise {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        // 底层源码调用的是AbstractStringbuffer的AppendNull()方法
        sb.append(str);
        System.out.println(sb.length());

        // 抛出NullpointerException
        // 底层源码 super(str.length()+16)
        // stringBuffer sb1 = new StringBuffer(str);
        // System.out.println(sb1);
    }
}
