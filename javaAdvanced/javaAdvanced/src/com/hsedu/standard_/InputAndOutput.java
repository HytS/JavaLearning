package com.hsedu.standard_;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        //System.in����������InputStream
        //System.in����������BufferedInputStream
        //System.in ��׼������
        System.out.println(System.in.getClass());

        //System.out����������PrintStream
        //System.out����������PrintStream
        //System.out��׼�����
        System.out.println(System.out.getClass());

        Scanner scanner = new Scanner(System.in);
        String next=scanner.next();
        System.out.println("next"+next);
    }
}
