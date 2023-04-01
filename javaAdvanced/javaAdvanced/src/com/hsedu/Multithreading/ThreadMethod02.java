package com.hsedu.Multithreading;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃"+i+"包子");
            if (i==5){
                t2.join();
            }
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            try {
                System.out.println("子线程吃"+i+"包子");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
