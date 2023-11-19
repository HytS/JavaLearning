package com.newedu.APP.collection.Set;

public class Apple implements Comparable<Apple>{
    private String name;
    private Double price;
    private int weight;

    public Apple() {
    }

    public Apple(String name, Double price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Apple o) {
        return this.weight-o.weight>=0 ? -1 : 1;
    }
}
