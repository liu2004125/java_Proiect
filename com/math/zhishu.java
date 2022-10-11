package com.math;

import java.util.Scanner;

public class zhishu {
    //质数，约数只有它和1 的数
    //优化，因为约数时成对出现，所以只需要枚举小的那部分
    //优化时间复杂度为sqrt(n)
    public static boolean find(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int a = scan.nextInt();
            if (find(a)) System.out.println("Yes");
            else System.out.println("No");

        }
    }
}
