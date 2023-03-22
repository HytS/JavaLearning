package com.hsedu.Set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet Set = new LinkedHashSet();
        Set.add(new Car("aoto",1200));
        Set.add(new Car("aoto",1200));
        Set.add(new Car("aoto",12000));
        System.out.println(Set);
    }
}
class Car{
    private String name;
    private double price;

    public Car(String name,double price){
        this.name=name;
        this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" "+price;
    }
}
