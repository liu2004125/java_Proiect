package com.DataStructure;

public class Heap {
    public static void main(String[] args) {
        int[] num = new int[]{0, 10, 2, 4, 3, 1, 8, 6, 7, 9, 5};
        heaps he = new heaps();
        he.build_max_heap_toup(num, num.length);
        for (int i = 1; i < num.length; i++)
            System.out.print(num[i] + " ");
    }
}

class heaps {
    //注意数组起始为1
    public int left(int i) {
        return i * 2;
    }

    public int right(int i) {
        return i * 2 + 1;
    }

    public int parent(int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public void build_max_heap_toup(int[] num, int size) {
        int heaplength = size;
        //自底向上
        for (int i = heaplength / 2; i >= 1; i--) {
            //从最后一位非叶子结点开始
            max_heap(num, i, heaplength);
        }
        //自顶向下
        for (int i = 1; i < size; i++) {
            //使用单个键的插入预先构造好的堆，而非整体数列变动
            max_heap_down(num, i);
        }
    }

    public void max_heap_down(int[] num, int i) {
        int p = parent(i);
        if (p < 1) return;
        if (num[p] < num[i]) {
            int temp = num[i];
            num[i] = num[p];
            num[p] = temp;
            max_heap_down(num, p);
        }
    }

    public void max_heap(int[] num, int i, int length) {
        //维护最大堆的属性
        int l = left(i);//左子结点下标
        int r = right(i);//右子结点下标
        int largest = i;//储存最大值的下标
        //找到最大值下标
        if (l < length && num[l] > num[i]) largest = l;
        if (r < length && num[r] > num[largest]) largest = r;

        if (i != largest) {
            int temp = num[i];
            num[i] = num[largest];
            num[largest] = temp;
            //为保证交换节点位置后，导致索引为max的节点比其子节点的值小，从而不符合堆结构，
            max_heap(num, largest, length);
        }
    }

    public void insert(int[] num, int val, int i, int length) {//length是当前数组长度，i是插入到队尾的下标
        num[i] = val;
        max_heap(num, i, length);
    }
}
