package com.hsedu.writer_;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("hello");

        out.write("world".getBytes());
        out.close();

        //
        //����޸ĳɵ�e:\f1.txt
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("hsedu");
    }
}
