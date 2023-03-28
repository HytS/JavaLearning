package com.hsedu.generic;

public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        Apple<String,Integer,Double> a=new Apple();
        a.fly(10);
        a.fly(new DogG());
    }
}
class Apple<T,R,M>{
    public <E> void fly(E e){
        System.out.println(e.getClass().getSimpleName());
    }

}
class DogG{

}