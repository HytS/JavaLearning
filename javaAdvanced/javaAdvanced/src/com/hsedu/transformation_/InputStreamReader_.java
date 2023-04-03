package com.hsedu.transformation_;

import com.hsedu.reader_.BufferedReader_;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReader_ {
    public static void main(String[] args) throws Exception{
        String filePath="e:\\a.txt";
        //把FileInputStream转成InputStreamReader
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");

        //把InputStreamReader传入BufferedReader
        BufferedReader br=new BufferedReader(isr);

        //读取
        String s=br.readLine();
        System.out.println("读取内容="+s);
        //关闭外层流
        br.close();
    }
}
