package com.newedu.APP.Genericity;

public class Test {
    public static void main(String[] args) {
//        MyArrayList<String> list = new MyArrayList<>();
//        list.add("abc");
//        list.add("abc");
//        list.add("abc");
//        System.out.println(list);
        Integer[] ints={12,23,45};
        printArray(ints);
    }
    public static <T> void printArray(T[] arr){
        if (arr != null) {
            StringBuffer sb=new StringBuffer("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i==arr.length-1?"":",");
            }
            sb.append("]");
            System.out.println(sb);
        }else {
            System.out.println(arr);
        }
    }
}
