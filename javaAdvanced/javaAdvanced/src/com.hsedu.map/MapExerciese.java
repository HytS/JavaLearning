package com.hsedu.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExerciese {
    public static  void main(String[] args) {
        Map map = new HashMap();
        map.put(1,new Employee("tom",123,1));
        map.put(2,new Employee("tom",123,2));
        map.put(3,new Employee("tom",123,3));



        //
        Set entrySet = map.entrySet();
        for (Object key:entrySet) {
            Employee e=(Employee)map.get(key);
            if (e.price>12000)
                System.out.println(e);
        }

        //

        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object entry=iterator.next();
            Map.Entry m=(Map.Entry)entry;
            Employee e=(Employee)m.getValue();
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}

class Employee{
    public String name;
    public double price;
    public int no;

    public Employee(String name, double price, int no) {
        this.name = name;
        this.price = price;
        this.no = no;
    }

    @Override
    public String toString() {
        return name+price+" "+no;
    }
}
