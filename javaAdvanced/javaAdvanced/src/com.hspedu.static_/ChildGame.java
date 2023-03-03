package com.hspedu.static_;

public class ChildGame {
    //int count=0;
    
    Child smith = new Child("smith");
    smith.count++;

    Child fox = new Child("fox");
    fox.count++;
    Child shu = new Child("shu");
    
    shu.count++;
    
}

/**
 * Child
 */
public class Child {
    private String name;

    //定义一个静态变量，
    public static int count=0;
    
    public  Child(String name) {
        this.name=name;
    }
    public void join() {
        System.out.println("join us");
    }

}