package com.Algorithm.sort;

public class heapsort {
    public static void main(String[] args) {
        int[] num = new int[]{10, 2, 4, 3, 1, 8, 6, 7, 9, 5};
        heaps he = new heaps();
        // for(int i =0;i<10;i++)
        //     he.build_max_heap(num,num.length);
        // for (int i = 0; i < 10; i++)
        //   System.out.print(num[i]+" ");
        System.out.println(he.heapsort(num));
    }
}

class heaps {
    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 2) * 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void build_max_heap(int[] num, int size) {
        int heaplength = size - 1;
        for (int i = heaplength; i > 0; i--) {
            max_heap(num, i, heaplength);
        }
    }

    public void max_heap(int[] num, int i, int length) {//自底向上
        //维护最大堆的属性
        int l = left(i);
        int r = right(i);
        int largest = -1;//储存最大值的下标
        //找到最大值下标
        if (l < length && num[l] > num[i]) {
            largest = l;
        } else largest = i;
        if (r < length && num[r] > num[largest]) {
            largest = r;
        }
        if (i != largest && i < length) {
            //交换一次i可能仍然不符合，最大堆的性质
            int temp = num[i];
            num[i] = num[largest];
            num[largest] = temp;
            max_heap(num, largest, length);
        }
    }

    public int[] heapsort(int[] num) {
        build_max_heap(num, num.length);
        int[] res = new int[num.length];
        int n = num.length - 1;

        for (int i = num.length - 1, j = 0; i > 2; i--) {
            num[i] = num[0];
            n--;
            max_heap(num, 0, n);
        }

        return num;
    }
}
