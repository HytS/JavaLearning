public class Deprecated {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
    }
}

/*
 * @Deprecated ����ĳ��Ԫ�أ���ʾ��Ԫ���Ѿ���ʱ
 * ���Ƽ�ʹ�ã�������Ȼ����ʹ��
 */
@Deprecated
class A {
    @Deprecated
    public int n1 = 20;

    public void hi() {

    }
}