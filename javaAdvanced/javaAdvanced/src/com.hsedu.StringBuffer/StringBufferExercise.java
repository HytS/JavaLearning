public class StringBufferExercise {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        // �ײ�Դ����õ���AbstractStringbuffer��AppendNull()����
        sb.append(str);
        System.out.println(sb.length());

        // �׳�NullpointerException
        // �ײ�Դ�� super(str.length()+16)
        // stringBuffer sb1 = new StringBuffer(str);
        // System.out.println(sb1);
    }
}
