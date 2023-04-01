package com.hsedu.FileOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String srcFilePath="d:\\a.jpg";
        String destFilePath="e:\\b.jpg";
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        byte[] bytes=new byte[1024];
        int readLen=0;
        try {
            fileOutputStream=new FileOutputStream(destFilePath);
            fileInputStream=new FileInputStream(srcFilePath);
            while ((readLen=fileInputStream.read(bytes))!=-1){
                //±ß¶Á±ßÐ´
                fileOutputStream.write(bytes,0,readLen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileOutputStream!=null)fileOutputStream.close();
                if (fileInputStream!=null)fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
