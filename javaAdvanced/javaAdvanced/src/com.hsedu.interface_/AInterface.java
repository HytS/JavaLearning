public interface AInterface {
    public int n1 = 200;

    // �ӿ��г��󷽷�����ʡ��abstract�ؼ���
    public void hi();

    default public void ok() {
        System.out.println("ok");

    }

    public static void cry() {
        System.out.println("cry");
    }
}
