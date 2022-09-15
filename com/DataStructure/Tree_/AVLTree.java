package com.DataStructure.Tree_;

public class AVLTree { //平衡二叉树
    public static void main(String[] args) {

    }
}

class node {

}

//    // 无论是左旋或是右旋 始终是针对两个节点(一个祖父节点和一个父节点)来进行操作的
//    // 至于child节点是可有可无的。
//    // 右旋转
//    private void rotateRight(Node<T> grand) {
//        // 右旋转
//        Node<T> parent = grand.left;
//        Node<T> child = parent.right;
//        grand.left = child;
//        parent.right = grand;
//        // 维护parent的父节点
//        parent.parent = grand.parent;
//        if (grand.isLeftNode()) {
//            grand.parent.left = parent;//将祖父结点转移为parent结点
//
//        } else if (grand.isRightNode()) {
//            grand.parent.right = parent;
//
//        } else {
//            // grand.parent==null
//            root = parent;
//
//        }
//        // 维护grand的父节点
//        grand.parent = parent;
//        // 维护child的父节点
//        if (child != null) {
//            child.parent = grand;
//        }
//
//        // 依次更新高度 从低节点到高节点
//        updateHeight(grand);
//        updateHeight(parent);
//    }
