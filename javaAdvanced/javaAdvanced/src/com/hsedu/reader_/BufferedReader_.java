package com.hsedu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {


    public static void main(String[] args) throws Exception {
        String filePath="e:\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        //�ر�����ֻ��Ҫ�ر�BufferedReader
        bufferedReader.close();
    }
}
