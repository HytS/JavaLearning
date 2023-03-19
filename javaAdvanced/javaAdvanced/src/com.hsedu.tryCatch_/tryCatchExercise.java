import java.lang.reflect.Method;

public class tryCatchExercise {
    public static void main(String[] args) {
        System.out.println(method());// 返回临时变量3
    }
}

class Exception {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[i]);
            } else {
                names[3] = "hsedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            return 2;
        } catch (NullPointerException e) {
            return i++;// 执行完++i之后会用临时变量保存i的值
        } finally {
            ++i;
            System.out.println(i);// 4
        }
    }
}
