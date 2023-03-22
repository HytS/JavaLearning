public class EnumMehod {
    public static void main(String[] args) {

        Season autumn = Season.SPRING;
        // ���ö�ٶ��������
        System.out.println(autumn.name());
        // ���ö�ٶ���Ĵ���
        System.out.println(autumn.ordinal());
        // �ӷ�������Կ���values����������Season[]
        // ���ж��������ö�ٶ���
        Season[] values = Season.values();
        for (Season season : values) {// ��ǿforѭ��
            System.out.println(season);
        }
        // valueOf ���ַ���ת����ö�ٶ���Ҫ���ַ���
        // ����Ϊ���еĳ������������쳣
        Season springSeason = Season.valueOf("SPRING");
        System.out.println(springSeason == autumn);// true
        // compareTo �Ƚ�����ö�ٳ������Ƚϵľ���λ�úţ���ţ�
        // return self.ordinal-other.ordinal
        System.out.println(Season.SPRING.compareTo(springSeason));
    }
}

enum Season {

    SPRING("spring", "warm"),
    WINTER("winter", "cool"), what();

    private String name;
    private String desc;

    private Season() {
    }

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
