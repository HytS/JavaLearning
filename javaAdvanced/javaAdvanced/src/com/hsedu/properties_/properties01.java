package com.hsedu.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mysql02.properties"));
        String line="";
        while ((line=br.readLine())!=null){
            String[] split=line.split("=");
            System.out.println(split[0]+"="+split[1]);
        }
        br.close();
    }
}
