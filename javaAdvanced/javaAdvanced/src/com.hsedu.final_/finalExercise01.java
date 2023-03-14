public class finalExercise01 {
    public static void main(String[] args) {

    }
}

class Circle {
    private double radius;
    private final double PI = 3.14;
    private final double PI_01;
    private final double PI_02;

    // 计算圆形面积，三种赋值方式
    public Circle(double radius) {
        this.radius = radius;
        PI_02 = 3.14;
    }

    {
        PI_01 = 3.14;
    }
}
