package com.newedu.APP.Genericity;

import java.util.ArrayList;

public class MyArrayList<E> {
    private ArrayList list = new ArrayList();
    public void add(E e){list.add(e);}
    public void remove(E e){list.remove(e);}
}
