package com.hsedu.OtherMethod;

import javax.management.RuntimeErrorException;

public class StringReverseExercise01 {
    public static void main(String[] args) {
        String str = "abcdef";
        try {
            str = reveString(str, 1, 4);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        System.out.println(str);
    }

    public static String reveString(String str, int start, int end) {

        if (!(str != null && start >= 0 && start < end && end < str.length())) {
//            throw new RuntimeErrorException("parameter false");
        }
        char[] chars = str.toCharArray();
        char tmp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
