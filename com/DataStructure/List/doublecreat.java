package com.DataStructure.List;

public class doublecreat {
    public static void main(String[] args) {

    }
}

class mmylist {
    public int num;
    nnode first = null;//比last慢/头节点，只指向一次
    nnode last = null;//当前位置

    public mmylist() {

    }

    public void creat(int n) {

        nnode newnode = new nnode(n);
        while (num < 5) {

            if (num == 0) {
                first = newnode;
                last = newnode;
            } else {
                last.setNext(newnode);//指向下一结点
                newnode.setFront(last);//从新结点的角度指向当前结点
                last = newnode;
            }
            num++;
        }
        first.setFront(null);
        last.setNext(null);
    }

    public void print() {
        nnode temp = first;
        while (temp.getNext() != null) {
            System.out.println("[" + temp.getNumber() + "]");
            System.out.println();
            temp = temp.getNext();
        }
    }
}

class nnode {
    private nnode front;
    private nnode next;
    private int number;

    public nnode(int number) {
        this.number = number;
    }

    public nnode getFront() {
        return front;
    }

    public void setFront(nnode front) {
        this.front = front;
    }

    public nnode getNext() {
        return next;
    }

    public void setNext(nnode next) {
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}