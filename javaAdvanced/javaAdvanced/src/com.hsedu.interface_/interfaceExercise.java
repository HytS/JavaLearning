package com.hsedu.interface_;

public class interfaceExercise {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}

interface Ain {
    int x = 1;
}

class Bin {
    int x = 2;
}

class Cin extends Bin implements Ain {
    public void pX() {
        System.out.println(Ain.x + " " + super.x);
    }
}
