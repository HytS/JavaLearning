package com.hsedu.transformation_;

import com.hsedu.reader_.BufferedReader_;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReader_ {
    public static void main(String[] args) throws Exception{
        String filePath="e:\\a.txt";
        //��FileInputStreamת��InputStreamReader
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");

        //��InputStreamReader����BufferedReader
        BufferedReader br=new BufferedReader(isr);

        //��ȡ
        String s=br.readLine();
        System.out.println("��ȡ����="+s);
        //�ر������
        br.close();
    }
}
