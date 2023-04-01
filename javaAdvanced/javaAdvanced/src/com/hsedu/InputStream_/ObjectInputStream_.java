package com.hsedu.InputStream_;

import com.hsedu.FileOutputStream.Dog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ObjectInputStream_ {
    public static void main(String[] args)  throws Exception{
        String FilePath="e:\\a.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));

        System.out.println(ois.read());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        Object dog=ois.readObject();
        System.out.println("类名"+ois.getClass());
        System.out.println("dog类信息"+dog);
        //Dog dog1=(Dog)dog;
       // System.out.println(dog1.getName());

        ois.close();
    }
}
