package com.hsedu.File;

import org.junit.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        String filePath="e:\\new1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete())
                System.out.println("ɾ���ɹ�");
            else
                System.out.println("ɾ��ʧ��");
        }else {
            System.out.println("�ļ�������");
        }
    }
    @Test
    public void m(){
        String filePath="e:\\demo1";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete())
                System.out.println("ɾ���ɹ�");
            else
                System.out.println("ɾ��ʧ��");
        }else {
            System.out.println("�ļ�������");
        }
    }

    @Test
    public void m1(){
        String directoryPath="e:\\demo1\\a\\b";
        File file = new File(directoryPath);
        if (file.exists()){
            System.out.println("Ŀ¼����");
        }else {
            if (file.mkdirs())
                System.out.println("�����ɹ�");
            else
                System.out.println("����ʧ��");
        }
    }
}
