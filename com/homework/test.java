package com.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 34, m = 21;
        System.out.println(feibo.cut(n,m));
    }
}
class feibo{

    public static int cut(int n,int m){//n，m是两个相邻的斐波那契数列的值
        int[] f = new int[n+1];
        f[n]=n;
        f[n-1]=m;
        int num=0;
        while(f[n]!=0){
            f[n-2]=f[n]-f[n-1];
            n--;
            num++;
        }
        return num;//正方形个数
        //时间复杂度为O(n)
    }
}