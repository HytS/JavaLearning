package com.hsedu.writer_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BuferedWriter_ {
    public static void main(String[] args) throws Exception{
        String filepath="e:\\abc.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath,true));
        bufferedWriter.write("hello");
        //����һ����ϵͳ��صĻ��з�
        bufferedWriter.newLine();
        bufferedWriter.write("world");
        bufferedWriter.close();
    }
}
