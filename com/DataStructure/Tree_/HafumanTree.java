package com.DataStructure.Tree_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HafumanTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input number");
        int n = in.nextInt();
        System.out.println("please intput data,struct is 'number'");
        hafuman hafuman = new hafuman();

        for (int i = 0; i < n; i++) {
            hafuman.insert(in.nextInt());
        }
        hafuman.build();
        hafuman.print();
    }
}

class node1 implements Comparable<node1> {
    private int data;
    private node1 lch, rch;

    public node1(int data) {
        this.data = data;
        this.lch = null;
        this.rch = null;
    }

    @Override
    public int compareTo(node1 o) {
        // return o.getData()-this.getData();//降序
        return this.getData() - o.getData();//升序
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public node1 getLch() {
        return lch;
    }

    public void setLch(node1 lch) {
        this.lch = lch;
    }

    public node1 getRch() {
        return rch;
    }

    public void setRch(node1 rch) {
        this.rch = rch;
    }

}

class hafuman {

    node1 lnode, rnode;
    List<node1> nodeList = new ArrayList<>();

    public void insert(int data) {
        nodeList.add(new node1(data));
    }

    public void print() {
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println(nodeList.get(i).getLch().getData());
            System.out.println(nodeList.get(i).getRch().getData());
        }
    }

    public void build() {

        // 因为每次都会remove一些节点，最终会在list中剩下一个节点，这个节点就是根节点
        while (nodeList.size() > 1) {
            // 从小到达排序list
            Collections.sort(nodeList);

            // 取出前两个最小的，第一个作为左节点，第二个作为右节点
            lnode = nodeList.get(0);
            rnode = nodeList.get(1);

            // 将权重+路径和赋值给父节点，将父节点的左右节点挂上
            node1 pnode = new node1(lnode.getData() + rnode.getData());
            pnode.setLch(lnode);
            pnode.setRch(rnode);

            // 移除最小的两个节点，将父节点放入list集合中，进行下一轮
            nodeList.remove(lnode);
            nodeList.remove(rnode);
            nodeList.add(pnode);
        }
    }

}