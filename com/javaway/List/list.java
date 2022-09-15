package com.javaway.List;

import java.util.Scanner;

//insert x y：将yy加入链表，插入在第一个值为x的结点之前。若链表中不存在值为xx的结点，则插入在链表末尾。保证xx,yy为int型整数。
//        delete x：删除链表中第一个值为xx的结点。若不存在值为xx的结点，则不删除。
public class list {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        mylist mylist = new mylist(n);
        for (int i = 0; i < n; i++) {
            String[] tempData = in.nextLine().split(" ");//split,分隔符，每次遇到空格分割一次
            switch (tempData[0]) {
                case "insert":
                    mylist.insert(Integer.parseInt(tempData[1]), Integer.parseInt(tempData[2]));
                    break;
                case "delete":
                    mylist.delete(Integer.parseInt(tempData[1]));
                    break;
            }
        }
    }
}

class mylist {
    private node head;
    private int length;

    mylist(int length) {
        this.length = length;
        node head = new node(null);//建立头节点
    }

    //插入数据
    public void insert(int value, int data) {
        node p = this.head;//后指针（当前位置）
        node q = this.head.getNext();//前指针
        while (q != null && q.getData() != value) {//while循环来遍历链表，直到找到需要的指针
            p = q;
            q = q.getNext();
        }
        if (q == null) {
            p.setNext(new node(data, null));//没找到，放在链表末尾
            this.length++;
        } else {
            p.setNext(new node(data, q));
            this.length++;
        }
    }

    public void output() {
        node temp = this.head.getNext();
        for (int i = 0; i < this.length; i++) {
            if (i == this.length - 1) {
                System.out.print(temp.getData());
                break;
            } else {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
        }
    }

    //删除表中和数据
    public void delete(int data) {
        node p = this.head;
        node q = this.head.getNext();
        while (q != null && p.getData() != data) {
            p = q;
            q = q.getNext();
        }
        if (q == null) {
            return;
        } else {
            p.setNext(q.getNext());//指向下一个结点
            this.length--;
        }
    }
}


class node {  //以自己为数据结构
    private int data;//数据储存
    private node next;//指针区域

    public node(node next) { //多态头节点
        this.next = next;
    }

    public node(int data, node next) { // 实际节点
        this.next = next;
        this.data = data;
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

    public node setNext(node next) {
        return next;
    }//建立新结点

}
