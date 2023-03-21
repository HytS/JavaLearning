package com.hsedu.Set_;

public class HashSetStructure {
    public static void main(String[] args) {
        Node[] table=new Node[16];
        for (int i = 0; i < 16; i++) {
            System.out.println(table[i]);
        }

        Node jack = new Node("jack",null);
        Node john = new Node("john",null);
        table[2]=jack;

        jack.next=john;




    }
}
class Node{
    Object item;
    Node next;
    public Node(Object item,Node next){
        this.item=item;
        this.next=next;
    }
}
