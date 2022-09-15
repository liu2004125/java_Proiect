package com.wuziqi;

import java.util.Scanner;

public class Try implements GoBandinterface {
    public static void Try1() {
        int x, y;
        Scanner in = new Scanner(System.in);
        while (true) {
            x = in.nextInt();
            y = in.nextInt();
            try {

                map[x - 1][y - 1] = 0;
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("你输入的格式不正确请重新输入");
            }
        }
        playchess.x = x;
        playchess.y = y;
    }
}
