package com.hsedu.Multithreading;

public class Thread03 {
    public static void main(String[] args) {
        Thread thread=new Thread(new AM());
        thread.start();
    }
}

class AM implements Runnable{
    @Override
    public void run() {
        int count=0;
       while (true){
           System.out.println("hi");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           count++;
           if (count==4) break;
       }

    }
}
class BM implements Runnable{
    @Override
    public void run() {
        int count=0;
        while (true){
            System.out.println("helloworld");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            if (count==10) break;
        }

    }
}
