package com.hsedu.OtherMethod;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("hlm", 12);
        books[1] = new Book("hlm", 12);
        books[2] = new Book("hlm", 12);

        Arrays.sort(books, new Comparator() {


            public int compare(Object o1, Object o2) {
                return 0;
            }


            public int compare(Book o1, Book o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double price = book1.getPrice() - book2.getPrice();
                if (price > 0) {
                    return 1;
                } else if (price < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }


        });

        System.out.println(Arrays.toString(books));
    }
}

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
