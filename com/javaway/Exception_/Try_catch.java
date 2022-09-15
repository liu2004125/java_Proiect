package com.javaway.Exception_;

import java.util.Scanner;

public class Try_catch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        String a = "";
        while (true) {
            a = in.nextLine();
            try {
                num = Integer.parseInt(a);//转换为整型
                break;
            } catch (NumberFormatException e) {  //如果发现异常，会跳过break回到while循环。
                System.out.println("你输入的不是一个整数，请重新输入");
            } finally { //无论是否有异常，finally 语句会被执行。（运行试试）
                // System.out.println("我在哪里");
                //  }
                // break;
            }
            System.out.println("你输入的整数为" + num);
        }
    }
}
