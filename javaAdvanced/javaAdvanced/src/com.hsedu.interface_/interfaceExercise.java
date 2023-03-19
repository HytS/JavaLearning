public class interfaceExercise {
    public static void main(String[] args) {

    }
}

interface A {
    int x = 1;
}

class B {
    int x = 2;
}

class C extends B implements A {
    public void pX() {
        System.out.println(A.x + " " + super.x);
    }
}
