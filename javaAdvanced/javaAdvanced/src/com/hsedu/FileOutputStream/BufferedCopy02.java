package com.hsedu.FileOutputStream;


import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath="e:\\a.jpg";
        String destFilePath="e:\\abc.jpg";
        //字节流可以操作二进制文件，也可以操作文本文件
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        int readLen=0;
        byte[] buf=new byte[1024];
        try {
            bis=new BufferedInputStream(new FileInputStream(srcFilePath));
            bos=new BufferedOutputStream(new FileOutputStream(destFilePath));
            while ((readLen=bis.read(buf))!=-1){
                bos.write(buf,0,readLen);
            }
            System.out.println("copy finish");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bis!=null) bis.close();
                if (bos!=null) bos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
