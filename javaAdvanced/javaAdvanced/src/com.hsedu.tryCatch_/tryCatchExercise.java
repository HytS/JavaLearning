package com.hsedu.tryCatch_;

import java.lang.reflect.Method;

public class tryCatchExercise {
    public static void main(String[] args) {

        //System.out.println(method());// ������ʱ����3
    }
}

class Exception extends Throwable {
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
            return i++;// ִ����++i֮�������ʱ��������i��ֵ
        } finally {
            ++i;
            System.out.println(i);// 4
        }
    }
}
