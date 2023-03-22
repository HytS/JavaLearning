package com.hsedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collectioniterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("sanguo", "lgz", 20));
        col.add(new Book("xlfd", "gl", 23.3));
        col.add(new Book("hlm", "cxq", 20.1));
        // ����col���ϣ���Ҫ�ȵõ�col�ĵ�����
        // ʹ��whileѭ��
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        // ���˳�whileѭ������ʱiterator�������Ѿ�ָ�����һ��Ԫ��
        // �����ִ��iterator.next()�����׳�NoSuchElementException�쳣

        // ��Ҫ���Ƶ�����
        iterator = col.iterator();
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.author = author;
        this.name = name;
        this.price = price;
    }

//    @Override
    public String toString(String name, String author, double price) {
        // TODO Auto-generated method stub
        return name + author + price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
