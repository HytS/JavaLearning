package com.hsedu.transformation_;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws Exception{
        String filePath="e:\\abc.txt";
        String charSet="gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi hello");
        osw.close();
        System.out.println();
    }
}
