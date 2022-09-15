package com.DataStructure.queue_;

import java.util.Scanner;

public class queue_list {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        que_list que = new que_list();
        System.out.println("inser入队，delete出队，stop停止");
        do {
            String[] str = in.nextLine().split(",");
            switch (str[0]) {
                case "insert":
                    que.insert(Integer.parseInt(str[1]));
                    break;
                case "delete":
                    que.delete();
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
    private int data;
    private node next;

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

class que_list {
    private node front;
    private node rear;

    public boolean Isempty() {
        return front == null;
    }

    public void print() {
        node index = front;
        while (index != null) {
            System.out.println(index.getData());
            index = index.getNext();
        }


    }

    public void insert(int n) {
        node newnode = new node(n);
        if (Isempty()) {
            front = newnode;
            rear = newnode;
        } else {
            rear.setNext(newnode);
            rear = rear.getNext();
        }
        print();
    }

    public void delete() {
        node index;
        if (Isempty()) {
            System.out.println("this is empty");
        }
        index = front;
        if (index == rear) {

            print();
            front = null;
            rear = null;
            System.out.println("empty for now");
        } else {
            front = index.getNext();

            print();
        }
    }
}