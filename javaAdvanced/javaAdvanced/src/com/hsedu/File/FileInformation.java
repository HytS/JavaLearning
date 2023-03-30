package com.hsedu.File;

import org.junit.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        File file=new File("e:\\new4.txt");
        System.out.println("文件名="+file.getName());
        System.out.println("文件绝对路径="+file.getAbsolutePath());
        System.out.println("文件父级目录="+file.getParent());
        System.out.println("文件大小="+file.length());
        System.out.println("文件是否存在="+file.exists());
        System.out.println("文件判断文件="+file.isFile());
        System.out.println("是不是目录="+file.isDirectory());


    }

}
