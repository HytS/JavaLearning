package com.hsedu.writer_;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {
        String srcFilePath="e:\\abc.txt";
        String destFilePath="e:\\a.txt";
        BufferedReader br = null;
        BufferedWriter bw= null;
        String line;
        try {
            br=new BufferedReader(new FileReader(srcFilePath));
            bw=new BufferedWriter(new FileWriter(destFilePath));
            while ((line= br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("finish");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br!=null) br.close();
                if (bw!=null) bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
