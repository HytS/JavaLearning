public class WrapperExerciese01 {
    public static void main(String[] args) {
        // ��Ԫ�������һ�����壬��Ҫ��������
        Object obj1 = true ? new Integer(1) : new Double(2);
        System.out.println(obj1);// 1.0

        Double d = 100d;// �Զ�װ�� Double.valueOf(100d)

        Object obj2;
        if (true) {
            obj2 = new Integer(1);
        } else {
            obj2 = new Double(2);
        }
        System.out.println(obj2);// 1
    }
}
