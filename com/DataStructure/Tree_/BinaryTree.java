package com.DataStructure.Tree_;

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input arrary'size (int) please");
        int n = in.nextInt();
        int[] data = new int[n];
        System.out.println("please input data");
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        Tree tree = new Tree(data);
        tree.Preorder(tree.rootnode);

    }
}

class TreeNode {
    private TreeNode lnode;
    private TreeNode rnode;
    private TreeNode parent;
    private int data;

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode(int data) {
        this.lnode = null;
        this.rnode = null;
        this.data = data;
        this.parent=null;
    }

    public TreeNode getLnode() {
        return lnode;
    }

    public void setLnode(TreeNode lnode) {
        this.lnode = lnode;
    }

    public TreeNode getRnode() {
        return rnode;
    }

    public void setRnode(TreeNode rnode) {
        this.rnode = rnode;
    }

    public int getData() {
        return data;
    }

}

class Tree {
    public TreeNode rootnode;//根结点

    public Tree(int[] value) {
        for (int i = 0; i < value.length; i++) {
            add(value[i]);
        }
    }
    private void balance(TreeNode cur){
        //根据二叉树的性质，左节点<父结点<右结点，找到右结点的左结点适合代替被删除结点的位置
        TreeNode template =cur.getParent();
        TreeNode parent =cur.getRnode().getLnode();
        parent.setParent(template);//template是祖先结点
        //维护新属性
        parent.setLnode(cur.getLnode());
        parent.setRnode(cur.getRnode());
        template.setLnode(parent);
        //旧结点的父节点为新结点
        cur.getRnode().setParent(parent);
        cur.getLnode().setParent(parent);
    }

    public void remove(int data){
        TreeNode template = rootnode;
        while (true) {
            if (data < template.getData()) {
                //找到树的最左端
                if (template.getLnode().getData() == data ) {
                    TreeNode Lnode = template.getLnode();
                    balance(Lnode);
                    return;
                } else {
                    template = template.getLnode();
                }
            } else {
                //找到树的最右端
                if (template.getRnode() == null) {
                    TreeNode Rnode = template.getLnode();
                    balance(Rnode);
                    return;
                } else {
                    template = template.getRnode();
                }
            }
        }
    }
    public void add(int data) {
        TreeNode template = rootnode;//临时结点，防止破坏根结点的指向
        if (rootnode == null) {
            rootnode = new TreeNode(data);
            return;
        }
        while (true) {
            if (data < template.getData()) {
                //找到树的最左端
                if (template.getLnode() == null) {
                    TreeNode child= new TreeNode(data);
                    template.setLnode(child);
                    child.setParent(template);
                    return;
                } else {
                    template = template.getLnode();
                }
            } else {
                //找到树的最右端
                if (template.getRnode() == null) {
                    TreeNode child= new TreeNode(data);
                    template.setLnode(child);
                    child.setParent(template);
                    return;
                } else {
                    template = template.getRnode();
                }
            }
        }
    }

    public void Preorder(TreeNode node) {//前序遍历
        if (node != null) {
            System.out.println(node.getData() + ",");
            Preorder(node.getLnode());
            Preorder(node.getRnode());
        }
    }

    public void Inorder(TreeNode node) {//中序遍历
        if (node != null) {
            Inorder(node.getLnode());
            System.out.println(node.getData() + ",");
            Inorder(node.getRnode());
        }
    }

    public void Lastorder(TreeNode node) {//后序遍历
        if (node != null) {
            Lastorder(node.getLnode());
            Lastorder(node.getRnode());
            System.out.println(node.getData() + ",");
        }
    }
}

