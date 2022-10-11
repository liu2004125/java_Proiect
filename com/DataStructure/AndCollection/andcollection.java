package com.DataStructure.AndCollection;

import java.util.Scanner;

public class andcollection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        while (m-- > 0) {
            String[] str = in.nextLine().split(" ");
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            if (str[0].equals("M")) {
                if (find(a, x) != find(a, x))
                    a[find(a, y)] = find(a, x);//y结点的祖先指向x的祖先
            }
            if (str[0].equals("Q")) {
                if (find(a, x) == find(a, y))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    public static int find(int[] a, int x) {
        if (a[x] != x) a[x] = find(a, a[x]);
        return a[x];
    }
}
