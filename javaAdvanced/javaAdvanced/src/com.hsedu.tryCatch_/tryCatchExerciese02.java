import java.util.Scanner;

public class tryCatchExerciese02 {
    public static void main(String[] args) {

    }
}

class Exercise {
    public void method() {
        // 如果用户输入的不是一个整数，
        // 就提示它反复输入，直到输入的是整数为止

        Scanner myScanner = new Scanner(System.in);
        int num = 0;
        String str = "";
        while (true) {
            str = myScanner.next();
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("it is not a num");
            }

        }
        System.out.println("it is a num");

    }
}
