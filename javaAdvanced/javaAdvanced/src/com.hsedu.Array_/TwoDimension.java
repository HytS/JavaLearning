package com.hsedu.Array_;

public class TwoDimension {
    public static void main(String[] args) {
        int[][] twoArr = new int[7][5];
        for (int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr[i].length; j++) {
                twoArr[i][j] = j + 1;
            }
        }

        for (int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr.length; j++) {
                System.out.println(twoArr[i][j]);
            }
        }
    }
}
