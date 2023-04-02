package com.hsedu.reader_;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void Reader01(){
        String filePath="e:\\story.txt";
        FileReader fileReader=null;
        int data=0;
        try {
            fileReader=new FileReader(filePath);
            while ((data=fileReader.read())!=-1){
                System.out.println((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader!=null) fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Test
    public void Reader02(){
        String filePath="e:\\a.txt";
        FileReader fileReader=null;
        int Readlen=0;
        char[] chars=new char[8];
        try {
            fileReader=new FileReader(filePath);
            while ((Readlen=fileReader.read(chars))!=-1){
                System.out.println(new String(chars,0,Readlen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader!=null) fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
