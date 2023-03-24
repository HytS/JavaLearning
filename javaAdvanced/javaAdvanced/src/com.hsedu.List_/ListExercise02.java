package com.hsedu.List_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("hlm", "wce", 20));
        list.add(new Book("hlm", "wce", 20));
        list.add(new Book("hlm", "wce", 20));
        list.add(new Book("hlm", "wce", 20));

    }

    public static void bubble(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = (Book) (list.get(j));
                Book book2 = (Book) (list.get(j + 1));
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
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

    @Override
    public String toString() {
        return name + ' ' + author + ' ' + price;
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
