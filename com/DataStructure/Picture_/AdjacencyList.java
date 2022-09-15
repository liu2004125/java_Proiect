package com.DataStructure.Picture_;


public class AdjacencyList {
    public static void main(String[] args) {
        int[][] data = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 3}, {1, 5}, {2, 4}, {2, 5}, {3, 5}, {5, 1}, {5, 4}};
        int i, j;
        GraphLink head[] = new GraphLink[6];
        System.out.println("邻接链表的内容");
        for (i = 1; i < 6; i++) {
            head[i] = new GraphLink();
            System.out.print("顶点" + i + "=>");
            for (j = 1; j < 6; j++) {
                if (data[j][0] == i) {//顶点从1开始
                    head[i].insert(data[j][1]);
                }
            }
            head[i].print();
        }

    }
}

class node {
    private node next;
    private int data;//顶点数据

    public node(int data) {
        this.next = null;
        this.data = data;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class GraphLink {
    private node first;
    private node last;

    public boolean isempty() {
        return first == null;
    }

    public void insert(int data) {
        node newnode = new node(data);
        if (isempty()) {
            first = newnode;
        } else {
            last.setNext(newnode);
        }
        last = newnode;
    }

    public void print() {
        node current = first;
        while (current != null) {
            System.out.print("[" + current.getData() + "]");
            current = current.getNext();
        }
        System.out.println();
    }
}

