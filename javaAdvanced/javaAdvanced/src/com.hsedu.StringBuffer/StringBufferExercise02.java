package com.hsedu.StringBuffer;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);
        String string = "1234566789.23";
        StringBuffer sb = new StringBuffer(string);
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i--) {
            sb = sb.insert(i, ',');
        }
    }
}
