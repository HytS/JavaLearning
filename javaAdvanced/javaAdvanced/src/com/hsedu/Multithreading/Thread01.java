package com.hsedu.Multithreading;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat=new Cat();
        //run方法就是普通方法没有真正的启动线程，只会把run方法执行完毕，才向下执行
        cat.start();
        //start0是本地方法，由jvm调用，底层是c/c++实现
        //真正实现多线程的效果是start0
        System.out.println("线程名="+Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+i);
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println("喵喵"+(++times)+"线程名字="+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==8) break;
        }


    }
}
