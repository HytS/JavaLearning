package com.hsedu.InputStream_;

import java.io.FileNotFoundException;

public class FileInputStream {
    public static void main(String[] args) {

    }
    public void readFile01() throws FileNotFoundException {
        String filepath="e:\\hello.txt";
        java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath);

    }

}
