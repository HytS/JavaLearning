public class final01 {
    public static void main(String[] args) {

    }
}

final class A {
    // final���ε��࣬��ϣ�����̳�
    public final void say() {
        System.out.println("hello");
    }
}

class B extends A {
    // final�������ԣ���ϣ������ֵ���޸�
    public final int N = 100010;

    // final���εĸ��෽���޷���
    // public void say() {
    // System.out.println("Bhello");
    // }
}

class C {
    // �ֲ�������ϣ�����޸�
    public void hello() {
        final int num = 100;
        // num=200;
        System.out.println(num);
    }

}
