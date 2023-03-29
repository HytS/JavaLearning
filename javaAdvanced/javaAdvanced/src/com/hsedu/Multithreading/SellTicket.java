package com.hsedu.Multithreading;

public class SellTicket {
    public static void main(String[] args) {
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
        SellTicket02 sellTicket01 = new SellTicket02();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
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
            System.out.println("´°¿Ú"+Thread.currentThread().getName()+"Ê£ÓàÆ±Êý"+(--ticketNum));
        }
    }
}

class SellTicket02 implements Runnable{
    private  int ticketNum=10;

    @Override
    public void run() {
        while (true){
            if (ticketNum==0){
                System.out.println("ticket is 0");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("´°¿Ú"+Thread.currentThread().getName()+"Ê£ÓàÆ±Êý"+(--ticketNum));
        }
    }
}