package com.hsedu.standard_;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        //System.in编译类型是InputStream
        //System.in运行类型是BufferedInputStream
        //System.in 标准输入流
        System.out.println(System.in.getClass());

        //System.out编译类型是PrintStream
        //System.out运行类型是PrintStream
        //System.out标准输出流
        System.out.println(System.out.getClass());

        Scanner scanner = new Scanner(System.in);
        String next=scanner.next();
        System.out.println("next"+next);
    }
}
