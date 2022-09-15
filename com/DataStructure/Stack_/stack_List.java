package com.DataStructure.Stack_;

import java.util.Scanner;

public class stack_List {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        sta_list sta = new sta_list();
        System.out.println("inser入队，delete出队，stop停止");
        do {
            String[] str = in.nextLine().split(",");
            switch (str[0]) {
                case "insert":
                    sta.insert(Integer.parseInt(str[1]));
                    break;
                case "pop":
                    sta.pop();
                    break;
                case "stop":
                    System.exit(0);
                default:
                    System.out.println("输入错误格式，重新输入");
                    break;
            }
        } while (true);
    }
}

class node {
    private node next;
    private int data;

    public node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }
}

class sta_list {

    private node front;
    private node rear;

    public boolean isempty() {//判断是否空栈
        return front == null;
    }

    public void insert(int n) {
        node newnode = new node(n);

        if (isempty()) {//第一个结点
            front = newnode;
            rear = newnode;
        } else {
            rear.setNext(newnode);
            rear = newnode;
        }
    }

    public void pop() {
        node index;//临时结点

        if (isempty()) {
            System.out.println("The stack is empty");
            return;
        }
        index = front;
        if (index == rear) {//虽然栈底指针不为空，但与栈顶指针重合，说明空栈了
            System.out.println("数据是" + index.getData());
            front = null;
            rear = null;
            System.out.println("now this stack is empty");
        } else {
            while (index.getNext() != rear)
                index = index.getNext();

            index.setNext(rear.getNext());//让rear的前一项指向null
            System.out.println("数据是" + rear.getData());//输出数据
            rear = index;//栈顶指针改变
        }

    }
}
