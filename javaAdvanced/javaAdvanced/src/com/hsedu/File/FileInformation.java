package com.hsedu.File;

import org.junit.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        File file=new File("e:\\new4.txt");
        System.out.println("�ļ���="+file.getName());
        System.out.println("�ļ�����·��="+file.getAbsolutePath());
        System.out.println("�ļ�����Ŀ¼="+file.getParent());
        System.out.println("�ļ���С="+file.length());
        System.out.println("�ļ��Ƿ����="+file.exists());
        System.out.println("�ļ��ж��ļ�="+file.isFile());
        System.out.println("�ǲ���Ŀ¼="+file.isDirectory());


    }

}
