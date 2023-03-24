package com.hsedu.List_;

public class LinkList01 {
    public static void main(String[] args) {
        Node jack=new Node("jack");
        Node tom=new Node("tom");
        Node js=new Node("js");
        //
        jack.next=tom;
        tom.next=js;
        js.prior=tom;
        tom.prior=jack;

        Node first=jack;
        Node last = js;


        //����һ������
        Node zs=new Node("zs");
        zs.next=js;
        js.prior=zs;
        zs.prior=tom;
        tom.next=zs;
        //��ͷ��β����
        while (true){
            if (first == null) {
                break;
            }
            System.out.println(first);
            first=first.next;
        }
        //��β��ͷ����
    }
}
class Node{
    public Object item;
    public Node next;
    public Node prior;
    public Node(Object name){
        this.item=name;
    }

    @Override
    public String toString() {
        return "Node name="+ item;
    }
}
