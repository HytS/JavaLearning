package com.hsedu.Multithreading;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat=new Cat();
        //run����������ͨ����û�������������̣߳�ֻ���run����ִ����ϣ�������ִ��
        cat.start();
        //start0�Ǳ��ط�������jvm���ã��ײ���c/c++ʵ��
        //����ʵ�ֶ��̵߳�Ч����start0
        System.out.println("�߳���="+Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("i="+i);
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println("����"+(++times)+"�߳�����="+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==8) break;
        }


    }
}
