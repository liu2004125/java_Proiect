package com.DataStructure.queue_;

import java.util.Scanner;

public class queue_arrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        queue queue = new queue(n);
        for (int i = 0; i < n; i++) {
            String[] str = in.nextLine().split(" ");
            if (str[0].equals("push")) {
                queue.push(Integer.parseInt(str[1]));
            } else if (str[0].equals("front")) {
                queue.top();
            } else {
                queue.pop();
            }
        }
    }
}


class queue {
    int front;
    int rear;
    int maxsize;
    int[] queue;

    queue(int n) {
        queue = new int[n];
        this.maxsize = n;
        front = 0;
        rear = 0;
    }

    public void push(int x) {
        if (rear == maxsize - 1) {
            System.out.println("error");
        } else {
            queue[rear++] = x;
        }
    }

    public void pop() {
        if (front == rear) {
            System.out.println("error");
        } else {
            System.out.println(queue[front++]);
        }
    }

    public void top() {
        if (front == rear) {
            System.out.println("error");
        } else {
            System.out.println(queue[front]);
        }
    }
}