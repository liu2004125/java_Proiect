package com.math;

import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(gcd(a, b));
        }
    }
}
//  证明  a%b=a-cb
//  当d/a ，d/b 则 d/a-cb 或者 d/a+cb
//  gcd(b,a % b) == gcd(b,a-cb) 因为 d/b , b/a-cb 则
//  因为d/b 则 d/cb
//  则 d/a-cb= d/a-cb+cb = d/a
