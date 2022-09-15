package com.DataStructure.queue_;

import java.util.Scanner;

public class requeue_Arrary {//循环队列，数组储存数据
    //front指向真实数据的前一位，为了判断队列是否为满
    public static int front = -1, rear = -1, val;
    public static int[] queue = new int[5];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (rear < 5 && val != -1) {
            System.out.println("请输入值来存放数据，输入0以取出数据，输入-1结束");
            val = in.nextInt();
            if (val == 0) {
                if (front == rear) {
                    System.out.println("队列已空");
                    break;
                }
                front++;//取出数据后队列前指针后移
                if (front == 5)
                    front = 0;
                System.out.println("取出值为" + queue[front]);
                queue[front] = 0;
            } else if (val != -1 && rear < 5) {
                if (rear + 1 == front || rear == 4 && front <= 0) {
                    System.out.println("队列已满");
                    break;
                }
                rear++;
                if (rear == 5)
                    rear = 0;
                queue[rear] = val;
            }
        }
        print();
    }

    public static void print() {
        System.out.println("队列剩余数据");
        if (front == rear) {
            System.out.println("队列已空");
        } else {
            while (front != rear) {
                front++;//因为front指向真实数据的前一位，所以先加
                if (front == 5)
                    front = 0;
                System.out.println(queue[front]);
                queue[front] = 0;
            }
        }
    }
}
