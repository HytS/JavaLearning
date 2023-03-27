package com.hsedu.generic;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

class AA implements IA{

    @Override
    public Double get(String s) {
        return null;
    }
}

class BB implements IF<Integer,Float>{

    @Override
    public Float get(Integer integer) {
        return null;
    }
}

class CC implements IF{

    @Override
    public Object get(Object o) {
        return null;
    }
}

interface IA extends IF<String,Double>{



}

interface IF<U,R>{
    int n=10;
    R get(U u);

}
