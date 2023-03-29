package com.hsedu.generic;

import java.util.ArrayList;
import java.util.Comparator;

public class genericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> em = new ArrayList<>();
        em.add(new Employee("tom",2000.0,new MyDate(2000,11,11)));
        em.add(new Employee("tom1",2000.0,new MyDate(2000,11,11)));
        em.add(new Employee("tom2",2000.0,new MyDate(2000,11,11)));

        em.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1 instanceof Employee&& o2 instanceof Employee){
                    return 0;
                }
                int i=o1.getName().compareTo(o2.getName());
                if (i!=0) return i;
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
    }
}

class Employee<E>{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {
        int yearMinus=this.year-o.year;
        if(yearMinus!=0) return yearMinus;
        int monthMinus=this.month-o.month;
        if (monthMinus!=0) return monthMinus;
        return this.day-o.day;
    }
}
