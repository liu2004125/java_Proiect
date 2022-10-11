package com.Algorithm.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class qiucksort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> num = new ArrayList<>();
//        while (in.hasNextInt()) {
//            num.add(in.nextInt());
//           String s = in.next();
//        }
        int[] num_1 = new int[]{2, 3, 1, 5, 4};
        // quicksort(num, 0, num.size() - 1);
        quicksort_1(num_1, 0, num_1.length - 1);
        for (int i = 0; i < num_1.length; i++)
            System.out.print(num_1[i]);
    }

    public static void quicksort(ArrayList num, int left, int right) {
        if (left > right) return;
        int temp = (int) num.get(left);
        int i = left + 1;
        int j = right;
        while (i < right) {
            while ((int) num.get(j) >= temp && i < j) j--;//找到比temp小的数

            while ((int) num.get(i) <= temp && i < j) i++;//找到比temp大的数
            if (i != j) {
                Object t = num.get(i);
                num.set(i, num.get(j));
                num.set(j, t);
            }
        }
        quicksort(num, left, i);
        quicksort(num, i + 1, right);
    }

    public static void quicksort_1(int[] a, int l, int r) {
        if (l >= r) return;
        //取中间值作为哨兵
        int x = a[(l + r) / 2], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (a[i] < x);
            do j--; while (a[j] > x);
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        quicksort_1(a, l, j);
        quicksort_1(a, j + 1, r);
    }
}


