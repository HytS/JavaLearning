public class Exception01 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;
        // int res = n1 / n2;// ������׳��쳣
        System.out.println();
        // �����������Ϊһ�δ�����ܳ����쳣�������ʹ��try-catch�쳣������ƽ��
        try {
            int res = n1 / n2;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());// ����쳣��Ϣ
        }
    }
}
