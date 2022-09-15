package com.DataStructure.Tree_;

import java.util.Scanner;

public class ThreadedTree {//在遍历中线索化二叉树

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input number");
        int n = in.nextInt();
        System.out.println("please input data");
        String[] input = in.nextLine().split(",");
        listtree listtree = new listtree();
        for (int i = 0; i < n; i++) {
            listtree.add(Integer.parseInt(input[i]));
        }
    }
}

class threadnode {
    public boolean ltrag;
    public boolean rtrag;
    private int data;
    private threadnode lnode;
    private threadnode rnode;

    public threadnode(int data) {
        this.data = data;
        this.lnode = null;
        this.rnode = null;
        ltrag = false;
        rtrag = false;
    }

    public threadnode getRnode() {
        return rnode;
    }

    public void setRnode(threadnode rnode) {
        this.rnode = rnode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public threadnode getLnode() {
        return lnode;
    }

    public void setLnode(threadnode lnode) {
        this.lnode = lnode;
    }
}

class listtree {
    threadnode rootnode = null;
    //trag=false代表为线索，trag=true代表为指针

    public void add(int data) {
        threadnode newnode = new threadnode(data);
        threadnode current;
        threadnode parent;
        threadnode previous = new threadnode(data);
        int pos;
        //设置头结点（根）
        if (rootnode == null) {
            rootnode = newnode;
            rootnode.setLnode(rootnode);
            rootnode.setRnode(null);
            rootnode.ltrag = false;
            rootnode.rtrag = true;//以右子节点作为连接
            return;
        }
        current = rootnode.getRnode();//第一个存放数据的结点
        //设置开头结点所指向的结点
        if (current == null) {
            rootnode.setRnode(newnode);
            newnode.setLnode(rootnode);
            newnode.setRnode(rootnode);
            return;
        }
        parent = rootnode;
        pos = 0;//树的行进方向
        while (current != null) {
            if (data < current.getData()) {//左边
                if (pos != -1) {//当第二次还是走左边时候，不经历这个循环，保证最左边的叶子结点指向根结点
                    pos = -1;
                    previous = parent;//指向前一个结点
                }
                parent = current;
                if (current.ltrag)
                    current = current.getLnode();//向下走
                else
                    current = null;
            } else {//右边
                if (pos != 1) {//同理，保证最右边的叶子结点指向树根
                    pos = 1;
                    previous = parent;
                }
                parent = current;
                if (current.rtrag)
                    current = current.getRnode();
                else
                    current = null;
            }
        }//此时current为null，就是叶子结点的子节点,对current的上一个结点存放数据
        if (data < parent.getData()) {
            parent.ltrag = true;
            parent.setLnode(newnode);
            newnode.setLnode(previous);
            newnode.setRnode(parent);
        } else {
            parent.rtrag = true;
            parent.setRnode(newnode);
            newnode.setLnode(parent);
            newnode.setRnode(previous);
        }
    }
}



