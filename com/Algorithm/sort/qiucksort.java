package com.Algorithm.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class qiucksort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> num = new ArrayList<>();
        while (in.hasNextInt()) {
            num.add(in.nextInt());
           String s = in.next();
        }
      //  int[] num = new int[]{10,2,4,3,1,8,6,7,9,5};
        quicksort(num, 0, num.size() - 1);
        for (int i = 0; i < num.size(); i++)
            System.out.print(num.get(i));
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
}
