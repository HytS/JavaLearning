public class Override {
    public static void main(String[] args) {

    }
}

class Son extends Father {
    @Override
    // ��û��@override������д
    // ���ûдoverride���������ͻ���÷����Ƿ������д�˸���ķ���
    // �����ȷ��д�ˣ������ͨ�������û����д�����뱨��
    public void fly() {
        System.out.println("son fly");
    }
}

class Father {
    public void fly() {
        System.out.println("flying");
    }
}
