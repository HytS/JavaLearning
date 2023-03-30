package com.hsedu.InputStream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filepath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            while ((readData = fileInputStream.read()) != -1) {
                System.out.println((char) readData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //�ر��ļ������ͷ���Դ
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Test
    public void readFile02() {
        String filepath = "e:\\hello.txt";
        int readlen = 0;
        byte[] buf = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            //�������-1�����ȡ���
            //�����ȡ����������ʵ�ʶ�ȡ���ֽ���
            while ((readlen = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readlen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //�ر��ļ������ͷ���Դ
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}