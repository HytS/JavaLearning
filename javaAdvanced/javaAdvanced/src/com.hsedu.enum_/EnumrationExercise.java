public class EnumrationExercise {
    public static void main(String[] args) {
        Week[] weeKs = Week.values();
        for (Week week : weeKs) {
            System.out.println(week);
        }
    }
}

enum Week {
    MONDAY("����һ"), TUSEDAY("���ڶ�"), WEDNESDAY("������"), THURSDAY("������"),
    FRIDAY("������"), SATURDAY("������"), SUNDAY("������");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString(String name) {
        return name;
    }
}
