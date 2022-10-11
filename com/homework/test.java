package com.homework;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        list list = new list();
        while (n-- > 0) {
            String s = scan.next();
            char op = s.charAt(0);
            if (op == 'L') {
                int x = scan.nextInt();
                list.insertL(x);
            } else if (op == 'R') {
                int x = scan.nextInt();
                list.insertR(x);
            } else if (op == 'D') {
                int k = scan.nextInt();
                list.delete(k);
            } else if (s.equals("IR")) {
                int k = scan.nextInt();
                int x = scan.nextInt();
                list.insertKR(k, x);
            } else {
                int k = scan.nextInt();
                int x = scan.nextInt();
                list.insertKL(k, x);
            }
        }
        node cur = list.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}

class node {
    public node prior;
    public node next;
    public int val;

    public node(int val) {
        this.prior = null;
        this.next = null;
        this.val = val;
    }
}

class list {
    public node head;
    public int length;

    public list() {
        this.length = 0;
    }

    public void insertL(int val) {
        node newnode = new node(val);
        if (this.length == 0) {
            newnode.prior = newnode;
            newnode.next = newnode;
            head = newnode;
        } else {
            newnode.prior = newnode;
            newnode.next = head;
            head.prior = newnode;
            head = newnode;
        }
        this.length++;
    }

    public void insertR(int val) {
        node newnode = new node(val);
        if (this.length == 0) {
            newnode.prior = newnode;
            newnode.next = newnode;
            head = newnode;
        } else {
            node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = newnode;
            newnode.prior = prev;
            newnode.next = null;
        }
        this.length++;
    }

    public void insertKR(int k, int val) {
        node newnode = new node(val);
        node prev = head;
        int temp = 0;
        while (prev.next != null && temp < k - 1) {
            prev = prev.next;
        }
        if (prev.next != null) {
            newnode.prior = prev;
            prev.next.prior = newnode;
            newnode.next = prev.next;
            prev.next = newnode;
        } else {
            prev.next = newnode;
            newnode.prior = prev;
            newnode.next = null;
        }
        this.length++;
    }

    public void insertKL(int k, int val) {
        node newnode = new node(val);
        node prev = head;
        int temp = 0;
        while (prev.next != null && temp < k - 2) {
            prev = prev.next;
        }
        if (prev.next != null) {
            newnode.prior = prev;
            prev.next.prior = newnode;
            newnode.next = prev.next;
            prev.next = newnode;
        } else {
            prev.next = newnode;
            newnode.prior = prev;
            newnode.next = null;
        }
        this.length++;
    }

    public void delete(int k) {
        node prev = head;
        int temp = 0;
        while (prev.next != null && temp < k - 1) {
            prev = prev.next;
        }
        node pre = prev.prior;
        if (prev.next != null) {
            node cur = prev.next;

            if (cur.next != null) {
                pre.next = cur;
                cur.prior = pre;
                prev.next = null;
                prev.prior = null;
            } else {
                pre.next = null;
            }
        }

        this.length--;
    }
}
