public class CustomException {
    public static void main(String[] args) throws AgeException {
        int age = 80;
        if (!(age >= 18 && age <= 120)) {
            // ����ͨ�������������Ϣ
            throw new AgeException("age is wrong");
        }
        System.out.println("age is yes");
    }
}

// �Զ����쳣
// һ��������Զ����쳣�̳�RuntimeException
// ���Զ����쳣��������ʱ�쳣����������ʹ��Ĭ�ϵĴ������
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
