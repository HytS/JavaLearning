package com.hsedu.interface_;

public class Interface02 {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

interface  AInterface{
    public void hi();
}
class AA implements AInterface {
    public void hi() {
        System.out.println("hi");
    }
}