package com.hsedu.tryCatch_;

public class TryCatchDetail {
    public static void main(String[] args) {

        // try {
        // String str = "123";
        // int a = Integer.parseInt(str);
        // System.out.println("nuim=" + a);
        // } catch (Exception e) {
        // // TODO: handle exception

        // System.out.println("exception=" + e.getMessage());
        // }

        try {
            Person p1 = new Person();
            // p1 = null;// 空指针异常

            System.out.println(p1.getName());
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;// 算术异常
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}

class Person {
    public String name = "javk";

    public String getName() {
        return name;
    }
}
