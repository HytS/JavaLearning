public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("��������");
            }
        });
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("С����Ͽ���");
            }
        });

    }

}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}
