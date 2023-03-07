package com.hsedu.Array_;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = { 20, 30, 5, 12, 56, 4, 58, 69 };
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 从小到大
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }
}
