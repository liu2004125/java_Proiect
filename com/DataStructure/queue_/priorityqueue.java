package com.DataStructure.queue_;

public class priorityqueue {
    public static void main(String[] args) {
        prqueue qu =new prqueue(12);
        int[] num =new int[]{1,5,9,8,3,2,4,6,7};
        for (int i = 0; i < num.length; i++) {
            qu.insert(num[i]);
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(qu.output());
        }
    }
}
class prqueue{//最小堆
    int rear=0;//同时代表元素个数
    int[] num;
    public prqueue(int n){
        num =new int[n];
    }
    public int left(int i){
        return (i+1)*2-1;
    }
    public int right(int i){
        return (i+1)*2;
    }
    public int parent(int i){
        if (i == 0) {
            return 0;
        }
        return (i-1)/2;
    }
    //先插入到队尾，再进行维护
    //插入的结点在末尾所以比较其父节点
    public void insert(int val){
        num[rear++]=val;//加入到队尾
        radjust(rear-1);//rear-1是其中含有的元素个数
    }
    //删除队首，将队尾赋值给队首，进行维护
    public int output(){
        int res=num[0];
        num[0]=num[--rear];
        num[rear]=0;
        fadjust(0,rear-1);
        return res;
    }
    //自上的有序化
    public void radjust(int i){
        int p=parent(i);
        int largest;
        if(i<rear && num[p]>num[i]){//
            largest =p;
        }else largest =i;
        if(i!= largest  ){
            swap(i,largest);
            radjust(largest);
        }
    }

    //自下的有序化
    public void fadjust(int i, int length){
        int l =left(i);
        int r=right(i);

        int largest;

        if(l<length && num[i]>num[l]){
            largest =i;
        }else largest =l;
        if(r<length && num[r]>num[largest]){
            largest =r;
        }
        if(i!= largest && i<length){
            swap(i, largest);
            fadjust(largest,length);
        }
    }
    public void swap(int a,int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
}
