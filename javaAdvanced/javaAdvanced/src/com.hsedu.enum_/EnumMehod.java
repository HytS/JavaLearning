public class EnumMehod {
    public static void main(String[] args) {

        // toString:Enum类已经重写了，返回的是当前对象名，
        // 子类可以重写该方法，用于返回对象的属性信息
        Season autumn = Season.SPRING;
        // 输出枚举对象的名字
        System.out.println(autumn.name());
        // 输出枚举对象的次序
        System.out.println(autumn.ordinal());
        // 从反编译可以看出values方法，返回Season[]
        // 含有定义的所有枚举对象
        Season[] values = Season.values();
        for (Season season : values) {// 增强for循环
            System.out.println(season);
        }
        // valueOf 将字符串转换成枚举对象，要求字符串
        // 必须为已有的常量名，否则报异常
        Season springSeason = Season.valueOf("SPRING");
        System.out.println(springSeason == autumn);// true
        // compareTo 比较两个枚举常量，比较的就是位置号（编号）
        // return self.ordinal-other.ordinal
        System.out.println(Season.SPRING.compareTo(springSeason));
    }
}

enum Season {

    SPRING("spring", "warm"), WINTER("winter", "cool");

    private String name;
    private String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
