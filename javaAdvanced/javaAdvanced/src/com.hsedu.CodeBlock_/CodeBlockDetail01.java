public class CodeBlockDetail01 {
    public static void main(String[] args) throws Exception {
        System.out.println(DD.n1);
    }
}

class DD {
    public static int n1 = 99;
    static {
        System.out.println("dd�ľ�̬����鱻ִ��");
    };
    {
        System.out.println("dd����ͨ����鱻ִ��");
    }
}

class CC {
    // ��̬���Գ�ʼ������̬���Ժ;�̬����鰴˳��ִ��
    public static int n1 = getN1();
    public int num = 20;
    private static int n2 = 200;
    static {

        System.out.println("CCd�ľ�̬�����");

        System.out.println(n2);
        // System.out.println(num);��̬���Դ����ֻ�ܵ��þ�̬��Ա
    }

    public static int getN1() {
        System.out.println("getN1()������");
        return 100;
    }
}