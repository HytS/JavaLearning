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
            //getBytes()���԰��ַ���תΪ�ַ�����
            String essay="hello,world";
//            fileOutputStream.write(essay.getBytes());
            //write(byte[] b,int off,int len)��len�ֽڴ�λ��ƫ����off��ָ���ֽ�����д����ļ������
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
