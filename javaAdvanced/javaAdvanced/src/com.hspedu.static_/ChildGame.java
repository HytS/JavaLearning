package com.hspedu.static_;

public class ChildGame {
    public static void main(String[] args) {
        int count=0;

        Child smith = new Child("smith");
        smith.count++;

        Child fox = new Child("fox");
        fox.count++;
        Child shu = new Child("shu");

        shu.count++;

    }
}

