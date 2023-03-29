package com.hsedu.Multithreading;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        System.out.println("main–›√ﬂ10s");
        Thread.sleep(10*1000);
        t.setLoop(false);
    }
}
class T extends Thread{
    private int count=0;
    private boolean loop=true;

    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("sleep"+(++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
