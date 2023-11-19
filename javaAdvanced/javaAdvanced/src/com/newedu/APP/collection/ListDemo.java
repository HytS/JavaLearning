package com.newedu.APP.collection;

import java.util.LinkedList;
import java.util.Stack;

public class ListDemo {
    public static void main(String[] args) {
        //队列
        LinkedList<String>  queue= new LinkedList<>();
        //入队
        queue.addLast("abc");
        queue.addLast("def");
        queue.addLast("ghi");
        System.out.println("入队完成");
        System.out.println(queue);
        System.out.println("出队");
        queue.forEach(s->{
            System.out.println(s);
        });
        System.out.println(queue.removeFirst());
        //栈
        System.out.println("========栈===========");
        LinkedList<String> stacks = new LinkedList<>();
        stacks.push("abc");
        stacks.push("ABC");
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());

    }
}
