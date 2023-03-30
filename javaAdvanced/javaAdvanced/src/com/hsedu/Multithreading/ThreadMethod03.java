package com.hsedu.Multithreading;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("hard working");
            Thread.sleep(1000);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            for(;;){
                System.out.println("happy chatting");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
