package com.hsedu.Multithreading;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        TS ts = new TS();
        System.out.println(ts.getName()+"state"+ts.getState());
        ts.start();
        while (Thread.State.TERMINATED!=ts.getState()){
            System.out.println(ts.getName()+"state"+ts.getState());
            Thread.sleep(2000);
        }
        System.out.println(ts.getName()+"state"+ts.getState());
    }
}

class TS extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 20; i++) {
                System.out.println("hello"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
}
