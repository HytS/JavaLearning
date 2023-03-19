public class OverLoadExercise {
    public static void main(String[] args) {
        Method method = new Method();
        method.m("hello a");
        method.m(10);
        method.m(10, 20);
    }
}

class Method {
    public void m(int num) {
        System.out.println(num * num);
    }

    public void m(int num, int num2) {
        System.out.println(num * num2);
    }

    public void m(String str) {
        System.out.println(str);
    }

    public int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    public double max(double n1, double n2, double n3) {
        return (n1 > n2 ? n1 : n2) < n3 ? n3 : (n1 > n2 ? n1 : n2);
    }

}
