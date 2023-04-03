package com.hsedu.writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath="e:abc.txt";
        FileWriter fileWriter=null;
        char[] chars={'a','n'};
        try {
            fileWriter=new FileWriter(filePath);
            fileWriter.write('H');
            fileWriter.write(chars);
            //写入指定数组的指定部分
            fileWriter.write("--hsedu".toCharArray(),0,3);
            fileWriter.write("--hsedu");
            fileWriter.write("--hsedu",0,1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileWriter!=null)fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
