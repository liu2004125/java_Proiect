package com.DataStructure;

public class Heap {
    public static void main(String[] args) {
        int[] num = new int[]{10,2,4,3,1,8,6,7,9,5};
        heaps he = new heaps();
        for(int i =0;i<10;i++)
            he.build_max_heap(num,num.length);
        for (int i = 0; i < 10; i++)
            System.out.print(num[i]+" ");
    }
}
class heaps{
    public int left(int i){
        return (i+1)*2-1;
    }
    public int right(int i){
        return (i+1)*2;
    }
    public int parent(int i){
        if (i == 0) {
            return -1;
        }
        return (i-1)/2;
    }
    public void build_max_heap(int[] num,int size){
        int heaplength=size;
        for (int i = heaplength; i >0 ; i--) {
            max_heap(num,i,heaplength);
        }
    }
    public void max_heap(int[] num,int i,int length){//维护最大堆的属性
        int l = left(i);
        int r=right(i);
        int largest=-1;//储存最大值的下标
        //找到最大值下标
        if(l<length && num[l]>num[i]  ){
            largest=l;
        }else largest=i;
        if(r<length && num[r]>num[largest]){
            largest=r;
        }
        if(i!=largest && i<length){
            //交换一次i可能仍然不符合，最大堆的性质
            int temp = num[i];
            num[i]=num[largest];
            num[largest]=temp;
            max_heap(num,largest,length);
        }
    }
    public void insert(int[] num,int val,int i,int length){//length是当前数组长度，i是插入到队尾的下标
        num[i]=val;
        max_heap(num,i,length);
    }
}
