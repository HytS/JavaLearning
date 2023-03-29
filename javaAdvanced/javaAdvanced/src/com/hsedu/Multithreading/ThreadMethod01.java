package com.hsedu.Multithreading;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();

        tt.setName("hs");
        tt.setPriority(Thread.MIN_PRIORITY);

        tt.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi"+i);
        }
        tt.interrupt();
    }
}
class TT extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+"eat dump");
            }
            try {
                System.out.println(Thread.currentThread().getName()+"relax");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"is interrupted");
            }
        }
    }
}
