package com.Algorithm.sort;

public class insertSort {
    //思想是将数据分为有序区间和无序区间，每次将无序区间的插入到有序区间
    public static void main(String[] args) {
        int[] t = new int[]{0, 10, 4, 6, 3, 2, 0, 8, 5, 9, 7, 1};
        int j;
        for (int i = 1; i < t.length - 1; i++) {
            if (t[i + 1] < t[i]) {
                //t[0]作为哨兵
                t[0] = t[i + 1];
                j = i + 1;
                do {
                    j--;
                    t[j + 1] = t[j];//依次后移
                } while (t[0] < t[j - 1]);
                t[j] = t[0];
            }
        }

        for (int i = 1; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
    }
}
