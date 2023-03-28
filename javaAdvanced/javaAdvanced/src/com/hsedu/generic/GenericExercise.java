package com.hsedu.generic;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();

        students.add(new Student("tom"));
        students.add(new Student("tom1"));
        students.add(new Student("tom2"));

        for(Student o:students){
            System.out.println(o);
        }
        System.out.println("====µü´úÆ÷====");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Object next=iterator.next();
            System.out.println(next);
        }

        System.out.println("hashMap±éÀú");


        HashMap<String, Student> map = new HashMap<String, Student>();
        //public class HashMap<K,V>
        map.put("abc",new Student("tom2"));
        map.put("absc",new Student("tom3"));
        map.put("abfc",new Student("tom4"));


        Set<Map.Entry<String, Student>> entries = map.entrySet();
        //    public Set<Map.Entry<K,V>> entrySet() {

        Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();
        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
        * */
        while (iterator1.hasNext()){
            Map.Entry<String, Student> next = iterator1.next();
            System.out.println(next);
        }
    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
