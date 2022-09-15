package com.wuziqi;

import java.util.Scanner;

public class playchess extends choice implements GoBandinterface {
    public static int x = 0, y = 0;

    public static void playchess1() {
        //缺乏输入格式错误问题
        Scanner in = new Scanner(System.in);

        if (whoturn % 2 == 0) {
            System.out.print("现在轮到玩家1下棋\n注意输入坐标格式为 x 空格 y\n");
            Try.Try1();

            while (0 != map[x][y]) {
                System.out.print("此处已有棋子，请重新落子");
                x = in.nextInt();
                y = in.nextInt();
            }
            map[x][y] = 1;
        }
        if (whoturn % 2 != 0) {
            System.out.print("现在轮到玩家2下棋\n注意输入坐标格式为 x 空格 y\n");
            Try.Try1();

            while (0 != map[x][y]) {
                System.out.print("此处已有棋子，请重新落子");
                x = in.nextInt();
                y = in.nextInt();
            }
            map[x][y] = 2;
        }
        //清屏
        if (judge.judge1(x, y)) {
            System.out.printf("玩家%d获胜\n", 1 + whoturn % 2);
            System.exit(0);
        }
    }
}
