package com.hsedu.FileOutputStream;

import java.io.*;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式，不是纯文本，而是按照它的格式来保存
        String filePath="e:\\a.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.write(100);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.0);
        oos.writeUTF("hsedu");
        oos.writeObject(new Dog("jj",10));


    }
}

//class Dog implements Serializable{
//    private String name;
//    private int age;
//
//    public Dog(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}