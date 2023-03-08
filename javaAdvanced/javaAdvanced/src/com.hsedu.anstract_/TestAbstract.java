public class TestAbstract {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime();
    }
}

class AA extends Template {

    public void job() {
        long num = 0;
        for (long i = 1; i <= 80000; i++) {
            num += i;
        }
        System.out.println(num);
    }
}

class BB {

}
