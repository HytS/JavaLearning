package com.hsedu.IOStream_;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

class BufferedReader_ {
    public Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    public void readFiles(int num){
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }
    public void readStrings(int num){
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }

}
class Test_{
    public static void main(String[] args) {
        BufferedReader_ bufferedReader=new BufferedReader_(new FileReader_());
        bufferedReader.readFiles(10);

        BufferedReader_ bufferedReader1=new BufferedReader_(new StringReader());
        bufferedReader1.readStrings(5);
    }
}
class FileReader_ extends Reader_{
    public void readFile(){
        System.out.println("read file");
    }



}
class StringReader extends Reader_{
    public void readString(){
        System.out.println("read string");
    }
}

abstract class Reader_{
    public void readFile(){}
    public void readString(){}
}

