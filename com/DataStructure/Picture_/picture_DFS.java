package com.DataStructure.Picture_;

public class picture_DFS {
    public static int[] run = new int[6];
    public static graphLink[] head = new graphLink[6];


    public static void DFS(int current) {
        run[current] = 1;
        System.out.println();
        while (head[current] != null) {
            if (run[head[current].first.getData()] == 0) {//类似与前序遍历
                DFS(head[current].first.getData());
                head[current].first = head[current].first.getNext();
            }
        }
    }

    public static void main(String[] args) {
        //
    }
}

class Node {
    private Node next;
    private int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class graphLink {
    public Node first;
    public Node last;

    public boolean isempty() {
        return first == null;
    }

    public void insert(int data) {
        Node newnode = new Node(data);
        if (isempty()) {
            first = newnode;
        } else {
            last.setNext(newnode);
        }
        last = newnode;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print("[" + current.getData() + "]");
            current = current.getNext();
        }
        System.out.println();
    }
}