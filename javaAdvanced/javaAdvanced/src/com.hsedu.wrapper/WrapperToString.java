public class WrapperToString {
    public static void main(String[] args) {
        // ��װ��Integer-->String
        Integer n1 = 100;// �Զ�װ��
        // ��ʽ1
        String str = n1.toString();
        // ��ʽ2
        String str2 = n1 + "";
        // ��ʽ3
        String str3 = String.valueOf(n1);

        // String -->��װ��
        String str4 = "123";
        Integer n2 = Integer.parseInt(str4);
        Integer n3 = new Integer(str4);
    }
}
