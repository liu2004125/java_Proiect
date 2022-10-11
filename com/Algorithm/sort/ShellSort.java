package com.Algorithm.sort;

public class ShellSort {
    //希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
    // 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 4, 12, 3, 7, 5, 6, 8, 9};
        insertionSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //希尔排序  升序
        for (int d = arr.length / 2; d > 0; d /= 2) { //d：增量  7   3   1
            for (int i = d; i < arr.length; i++) {
                //i:代表即将插入的元素角标，作为每一组比较数据的最后一个元素角标
                //j:代表与i同一组的数组元素角标
                for (int j = i - d; j >= 0; j -= d) { //在此处-d 为了避免下面数组角标越界
                    if (arr[j] > arr[j + d]) {// j+d 代表即将插入的元素所在的角标
                        //符合条件，插入元素（交换位置）
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
            }
        }
    }
}
