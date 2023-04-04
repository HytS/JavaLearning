package com.hsedu.OtherMethod;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = { 1, -1, 8, 0, 20 };

//        bubble02(arr, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int i1 = (int) o1;
//                int i2 = (int) o2;
//                return i1 - i2;
//            }
//        });

        System.out.println(Arrays.toString(arr));
    }

    // bubblesort
    public static void bubblesort(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {

                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

//    public static void bubble02(int[] arr, Comparator c) {
//        int tmp = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (c.compare(arr[j], arr[j + 1])) {
//
//                    tmp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tmp;
//                }
//            }
//        }
//    }
}
