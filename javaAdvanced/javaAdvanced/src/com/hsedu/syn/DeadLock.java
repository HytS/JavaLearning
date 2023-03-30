package com.hsedu.syn;

public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(false);
        deadLockDemo.setName("A");
        deadLockDemo1.setName("B");
        deadLockDemo.start();
        deadLockDemo1.start();
    }
}

class DeadLockDemo extends Thread{
    static Object o1= new Object();
    static Object o2= new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"enter 1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"enter 2");

                }
            }

        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+" enter 3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"enter 4");

                }
            }
        }
    }
}
