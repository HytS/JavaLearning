public class WrapperExercise03 {
    public static void main(String[] args) {
        Integer i5 = 127;// ʹ�õײ��Integer.valueOf()
        Integer i6 = 127;
        System.out.println(i5 == i6);
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);
        Integer i9 = 127;
        int i10 = 127;
        // ֻҪ�л������������жϵľ���ֵ�Ƿ���ͬ
        System.out.println(i9 == i10);
    }
}
