package com.hsedu.FileOutputStream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void m1(){
        String filepath="e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream=new FileOutputStream(filepath,true);
//            fileOutputStream.write('a');
            //getBytes()可以把字符串转为字符数组
            String essay="hello,world";
//            fileOutputStream.write(essay.getBytes());
            //write(byte[] b,int off,int len)将len字节从位于偏移量off的指定字节数组写入此文件输出流
            fileOutputStream.write(essay.getBytes(),3,7);
        } catch (IOException e) {

            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
