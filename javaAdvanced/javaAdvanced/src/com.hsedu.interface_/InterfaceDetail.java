public class InterfaceDetail {
    public static void main(String[] args) {
        // ����ͨ���ӿ������ʾ���static��
        System.out.println(IB.a);

        // IB.a=2; final������ı�
    }
}

interface IB {
    int a = 1;// public ���֤��

    void hi();
}

interface IC {
    void say();
}

public interface ID extends IB, IC {
    // �ӿڵ����η�ֻ����public��Ĭ��
}

class Pig implements IB, IC {
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}
