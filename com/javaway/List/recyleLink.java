package com.javaway.List;

public class recyleLink {//防止头结点丢失导致链表丢失

    public static void main(String[] args) {


    }
}

class nnnode {
    private int data;
    private nnnode next;

    public nnnode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public nnnode getNext() {
        return next;
    }

    public void setNext(nnnode next) {
        this.next = next;
    }
}

class llist {
    private nnnode first;
    private nnnode last;
    private int n = 0;

    public void creat(int data) {//输入数据
        nnnode newnode = new nnnode(data);
        while (data != 0) {
            if (n == 0) {
                first = newnode;
                last = newnode;
            } else {
                last.setNext(newnode);
                last = newnode;
            }
            n++;
        }
        last.setNext(first);//环形
    }


}