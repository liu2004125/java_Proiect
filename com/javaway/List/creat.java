package com.javaway.List;

import java.util.Scanner;

//输入一个数确定链表大小
//输入数据，以回车为结束；
public class creat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Mylist mylist = new Mylist();
        mylist.creatlist(n);
    }
}

class Mylist {
    public int num = 0;
    private Node head = null;//head只用一次是头节点，相当于开始
    //就是一个节点，不像c中的指针，可直接用于连接
    private Node next = null;

    public Mylist() {

    }

    public void creatlist(int n) {

        Node not = new Node(n);//每次建立一个节点

        while (num < 5) {
            if (num == 0) {
                head = not;
                next = not;
            } else {
                next.setNext(not);
                next = not;
            }
            num++;
        }
        next.setNext(null);
    }

}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

