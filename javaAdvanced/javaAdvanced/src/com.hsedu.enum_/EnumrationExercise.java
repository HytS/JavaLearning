package com.hsedu.enum_;

public class EnumrationExercise {
    public static void main(String[] args) {
        Week[] weeKs = Week.values();
        for (Week week : weeKs) {
            System.out.println(week);
        }
    }
}

enum Week {
    MONDAY("星期一"), TUSEDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期天");

    private String name;

    private Week(String name) {
        this.name = name;
    }

//    @Override
    public String toString(String name) {
        return name;
    }
}
