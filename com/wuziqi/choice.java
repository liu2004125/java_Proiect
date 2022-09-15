package com.wuziqi;

import java.util.Scanner;

public class choice implements GoBandinterface {
    public static int whoturn = 0;

    public static void interface_1() {
        System.out.println("输入数字以选择功能\n");
        System.out.println("   1---玩家对战\n");
        System.out.println("   2---规则说明\n");
        System.out.println("   3---退出游戏\n");
        System.out.println("输入数字以选择");
        Scanner in = new Scanner(System.in);
        int[] b = {0, 1, 2, 3};
        int i;

        while (true) {
            String s = in.nextLine();
            try {
                int t = Integer.parseInt(s);
                i = b[t];
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的格式不对");
            } catch (Exception e1) {
                System.out.println("请输入有效的数字");
            }
        }
        switch (i) {
            case 1: {
                while (true) {
                    chessprint.chessprintf(map);
                    playchess.playchess1();
                    whoturn++;
                }
            } //break;
            case 2: {
                rule.rule1();

            }
            break;
            case 3: {
                System.exit(0);
            }
        }
    }
}
