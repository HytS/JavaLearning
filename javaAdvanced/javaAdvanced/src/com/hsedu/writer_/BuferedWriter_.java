package com.hsedu.writer_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BuferedWriter_ {
    public static void main(String[] args) throws Exception{
        String filepath="e:\\abc.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath,true));
        bufferedWriter.write("hello");
        //插入一个和系统相关的换行符
        bufferedWriter.newLine();
        bufferedWriter.write("world");
        bufferedWriter.close();
    }
}
