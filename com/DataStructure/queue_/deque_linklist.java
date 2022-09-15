package com.DataStructure.queue_;

import java.util.Scanner;

public class deque_linklist {//双端队列
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

class Deque1 {
    private quenode front;
    private quenode rear;
    private int size = 0;

    public void right_insert(int val) {
        quenode newnode = new quenode(val);
        if (front == null) {
            front = newnode;
            front.setLeft(null);
            rear = newnode;
            rear.setRight(null);
        } else {
            rear.setRight(newnode);
            quenode temp = rear;
            rear = rear.getRight();
            rear.setLeft(temp);
        }
    }

    public void right_remove() {
        quenode temp = front;
        if (rear == temp) {
            System.out.println("队列已空");
        } else {
            while (temp.getLeft() != rear)
                temp = temp.getLeft();
            System.out.println(rear.getData());
            rear = null;
            temp.setRight(rear);
            rear = temp;
        }
    }

    public void left_insert(int val) {
        quenode newnode = new quenode(val);
        if (front == null) {
            front = newnode;
            front.setLeft(newnode);
            rear = newnode;
        } else {
            front.setLeft(newnode);
            quenode temp = front;
            front = front.getLeft();
            front.setRight(temp);
        }
    }

    public void left_remove() {
        quenode temp = rear;
        if (front == temp) {
            System.out.println("队列已空");
        } else {
            while (temp.getLeft() != front)
                temp = temp.getLeft();
            System.out.println(front.getData());
            front = null;
            temp.setLeft(front);
            front = temp;
        }
    }

    public void print() {
        quenode t = front;
        System.out.println("当前队列数据为：");
        while (t != null) {
            System.out.println(t.getData());
            t = t.getRight();
        }
    }
}

class quenode {
    private int data;
    private quenode right;
    private quenode left;

    public quenode(int data) {
        this.data = data;
        this.right = null;
    }

    public quenode getRight() {
        return right;
    }

    public void setRight(quenode right) {
        this.right = right;
    }

    public quenode getLeft() {
        return left;
    }

    public void setLeft(quenode left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}