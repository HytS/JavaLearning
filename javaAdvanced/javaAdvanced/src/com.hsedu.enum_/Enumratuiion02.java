public class Enumratuiion02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}

enum Season {
    // ʹ��enumʵ��ö����
    // ʹ�ùؼ���enum����class
    // ������(ʵ���б�)
    // ����ж��������ʹ�ã��ż��
    // ���ʹ��enumʵ��ö�٣�Ҫ�󽫶��峣������д��ǰ��
    SPRING("spring", "warm"), WINTER("winter", "cool");

    private String name;
    private String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
