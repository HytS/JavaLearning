package com.hsedu.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    public void create01(){
        String filePath="e:\\new1.txt";
        File file=new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void create02(){
        File parFile= new File("e:\\");
        String fileName="new2.txt";
        File file = new File(parFile, fileName);
        try {
            file.createNewFile();
            System.out.println("new2创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void create03(){
        String filepath= "e:\\";
        String fileName="new3.txt";
        File file = new File(filepath, fileName);
        try {
            file.createNewFile();
            System.out.println("new3创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
