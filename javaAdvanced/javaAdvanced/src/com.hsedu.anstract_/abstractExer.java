package com.hsedu.anstract_;

public class abstractExer {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

/**
 * Employee
 */
abstract class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}

/**
 * Manage
 */
class Manage extends Employee {
    double bonus;

    public Manage(String name, int id, double salary) {
        super(name, id, salary);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void work() {
        System.out.println(getName());
    }

}

class CommonEmployee extends Employee {
    CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    public void work() {
        System.out.println(getName());
    }
}