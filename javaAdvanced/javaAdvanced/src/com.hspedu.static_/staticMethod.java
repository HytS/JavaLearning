public class staticMethod {
    public static void main(String[] args) {
        Stu s1 = new Stu("tom");
        s1.payFee(100);

    }
}

class Stu {
    private String name;
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    // ��̬�������Է��ʾ�̬����
    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("��ѧ��=" + Stu.fee);
    }
}