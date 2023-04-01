package com.hsedu.Multithreading;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        TA ta = new TA();
        Thread thread = new Thread(ta);
        for (int i=1;i<=10;i++){

            Thread.sleep(1000);
            System.out.println("hi");
            if (i==5){
                thread.start();
                thread.join();
            }
        }
    }
}

class TA implements Runnable{
    @Override
    public void run() {
        int count=0;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            count++;
            if (count==10) break;
        }
    }
}