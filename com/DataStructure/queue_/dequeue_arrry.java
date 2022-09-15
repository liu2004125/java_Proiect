package com.DataStructure.queue_;

import java.util.Scanner;

public class dequeue_arrry {

    public static int size;
    public static int left = -1, right = -1, val;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque1 deque = new Deque1();
        System.out.println("请输入数据，格式为（left/right）0/1，,data  1代表insert，0代表删除");
        String[] str = in.nextLine().split(",");
        while (!str[0].equals("0")) {
            if (str[0].equals("0")) break;
            switch (str[0]) {
                case "left1": {
                    deque.left_insert(Integer.parseInt(str[1]));
                    deque.print();
                }
                break;
                case "left0": {
                    deque.left_remove();
                    deque.print();
                }
                break;
                case "right1": {
                    deque.right_insert(Integer.parseInt(str[1]));
                    deque.print();
                }
                break;
                case "right0": {
                    deque.right_remove();
                    deque.print();
                }
                break;
                default:
                    System.out.println("输入格式不对，请重新输入");
            }
            str = in.nextLine().split(",");
        }
    }
}
