public class StringExercise01 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";
        // 1���ȴ���һ������ StringBuilder sb=new StringBuilder();
        // 2��ִ��sb.append("hello") 3��sb.append("abc")
        // sb���ڶ��У�����append����ԭ���ַ����Ļ�����׷�ӵ�
        // 4��String c=sb.toString()
        // ���cָ����еĶ���(String)value[]->����"helloabc"
        String c = a + b;// һ����3������
    }
}
