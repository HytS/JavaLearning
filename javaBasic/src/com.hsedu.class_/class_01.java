import java.util.Scanner;

public class class_01 {
    public static void main(String[] args) {
        AA aa = new AA();
        Scanner myScanner = new Scanner(System.in);
        aa.oddAndEven(myScanner);

    }
}

class AA {
    int num;

    public void oddAndEven(int num) {
        if (num % 2) {
            System.out.println("odd");
        } else
            System.out.println("even");
    }
}
