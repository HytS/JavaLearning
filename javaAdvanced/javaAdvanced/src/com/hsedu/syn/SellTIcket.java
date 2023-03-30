package com.hsedu.syn;

public class SellTIcket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        com.hsedu.Multithreading.SellTicket02 sellTicket01 = new com.hsedu.Multithreading.SellTicket02();
//        new Thread(sellTicket01).start();
//        new Thread(sellTicket01).start();
//        new Thread(sellTicket01).start();
        SellTicket02 sellTicket02 = new SellTicket02();
        Thread thread = new Thread(sellTicket02);
        thread.start();
    }
}

class SellTicket01 extends Thread{
    private static int ticketNum=100;

    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                System.out.println("ticket is 0");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("����"+Thread.currentThread().getName()+"ʣ��Ʊ��"+(--ticketNum));
        }
    }
}

class SellTicket02 implements Runnable{
    private  int ticketNum=10;
    private boolean loop=true;
    Object object=new Object();
    //ͬ���������Ǿ�̬������������this��Ҳ��������������Ҫ����ͬһ������
    public synchronized void m1(){
        synchronized (object/*this*/){
            System.out.println("obj");
        }
    }

    public static void m2(){
        synchronized (SellTicket02.class){
            System.out.println("sss");
        }
    }

    public /*synchronized*/ void sell(){

           synchronized (object){
               if (ticketNum<=0){
                   System.out.println("ticket is 0");
                   loop=false;
                   return;
               }
           }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("����"+Thread.currentThread().getName()+"ʣ��Ʊ��"+(--ticketNum));

    }
    @Override
    public void run() {
      while (loop){
          sell();
      }
    }
}