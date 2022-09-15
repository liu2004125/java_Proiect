package com.javaway.Algorithm;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //斐波那契数列求和，繁衍问题
        String[] str = in.nextLine().split(",");
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            sum += feibo(Integer.parseInt(str[i]));
        }
        System.out.println(sum);
    }

    //递归法
    public static int feibo(int n) {//n就是数列的第n项
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return feibo(n - 1) + feibo(n - 2);
        }
    }

    //迭代法,记录已经计算的部分
    public static int feibo1(int n) {
        if (n == 1 || n == 2) return 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
