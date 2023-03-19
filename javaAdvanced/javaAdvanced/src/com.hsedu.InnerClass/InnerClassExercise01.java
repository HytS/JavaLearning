public class InnerClassExercise01 {
    public static void main(String[] args) {
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("this is a famous picture");
            }
        });
    }

    public static void f1(IL il) {
        System.out.println("say");
    }
}

interface IL {
    public void show();
}
