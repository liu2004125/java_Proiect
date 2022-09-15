package com.DataStructure.Tree_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HafumanTree {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input number");
        int n = in.nextInt();
        System.out.println("please intput data,struct is 'number,weight'");
        hafumantree hafuman = new hafumantree();

        for (int i = 0; i < n; i++) {
            String[] str = in.nextLine().split(",");

        }

    }
}

class Treenode {
    private int data;
    private Treenode lch, rch;
    private int weight;

    public Treenode(int data, int weight) {
        this.data = data;
        this.lch = null;
        this.rch = null;
        this.weight = weight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Treenode getLch() {
        return lch;
    }

    public void setLch(Treenode lch) {
        this.lch = lch;
    }

    public Treenode getRch() {
        return rch;
    }

    public void setRch(Treenode rch) {
        this.rch = rch;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class hafumantree {
    Treenode min1, mnin2;
    Treenode lnode, rnode;

    public void create(int data, int weight) {

        List<Integer> list = new ArrayList<>();
        // 因为每次都会remove一些节点，最终会在list中剩下一个节点，这个节点就是根节点
        while (list.size() > 1) {
            // 从小到达排序list
//            List.sort(list);
//
//            // 取出前两个最小的，第一个作为左节点，第二个作为右节点
//            Node leftNode = nodeList.get(0);
//            Node rightNode = nodeList.get(1);
//
//            // 将权重+路径和赋值给父节点，将父节点的左右节点挂上
//            Node parentNode = new Node(leftNode.getValue()+rightNode.getValue());
//            parentNode.setLeft(leftNode);
//            parentNode.setRight(rightNode);
//
//            // 移除最小的两个节点，将父节点放入list集合中，进行下一轮
//            nodeList.remove(leftNode);
//            nodeList.remove(rightNode);
//            nodeList.add(parentNode);


        }
    }

}