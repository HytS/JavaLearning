package com.newedu.APP.collection;

import java.util.LinkedList;
import java.util.Stack;

public class ListDemo {
    public static void main(String[] args) {
        //����
        LinkedList<String>  queue= new LinkedList<>();
        //���
        queue.addLast("abc");
        queue.addLast("def");
        queue.addLast("ghi");
        System.out.println("������");
        System.out.println(queue);
        System.out.println("����");
        queue.forEach(s->{
            System.out.println(s);
        });
        System.out.println(queue.removeFirst());
        //ջ
        System.out.println("========ջ===========");
        LinkedList<String> stacks = new LinkedList<>();
        stacks.push("abc");
        stacks.push("ABC");
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());

    }
}
