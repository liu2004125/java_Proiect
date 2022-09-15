package com.wuziqi;

import java.util.Scanner;

public class rule {
    public static void rule1() {
        System.out.print("双方分别使用 O 和 X 两色的棋子，\n");
        System.out.print("下在棋盘直线与横线的交叉点上，先形成五子连线者获胜\n");
        System.out.print("通过输入坐标进行下子\n");
        System.out.print("双方轮流下棋，当出现输赢时，程序将自动展示结果\n");
        System.out.println();
        System.out.print("按下 0 返回开始菜单\n");
        System.out.println("否则，退出程序");
        Scanner in = new Scanner(System.in);
        if (in.nextInt() == 0)
            choice.interface_1();
        else
            System.exit(0);
    }
}
