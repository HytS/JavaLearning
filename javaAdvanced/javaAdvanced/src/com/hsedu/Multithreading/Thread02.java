package com.hsedu.Multithreading;

public class Thread02 {
    public static void main(String[] args) {
//        Thread thread=new Thread(new Dog());
//        thread.start();
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Tiger implements Runnable{
    @Override
    public void run() {
        System.out.println("�ϻ���");
    }
}
class ThreadProxy implements Runnable{
    private Runnable target=null;

    @Override
    public void run() {
        if (target!=null) target.run();//target��̬�󶨴������Ķ���

    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }
    public  void start0(){
        run();
    }
}
class Dog implements Runnable{
    @Override
    public void run() {
        int count=0;
        while (true){
            System.out.println("����"+(++count)+"name="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count==10) break;
        }
    }
}
