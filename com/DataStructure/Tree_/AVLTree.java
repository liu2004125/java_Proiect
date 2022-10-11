package com.DataStructure.Tree_;

public class AVLTree { //平衡二叉树
    //1.平衡因子
    //2.左旋及右旋操作
    //3.判断旋转类型，RL,LL,RR,LR
    //4.LR ，左旋+右旋  RR 一次右旋   LL 一次左旋   RL 左旋+右旋
    //5.更新属性（平衡因子）
    public static void main(String[] args) {

    }


}

class AVLNode {
    AVLNode lch;
    AVLNode rch;
    AVLNode parent;
    int data;
    int height = 1;//平衡因子

    public AVLNode(int data) {
        this.data = data;
        this.lch = null;
        this.rch = null;
        this.parent = null;
    }

    public int balanceFactory() {//获得平衡因子
        int leftHeight = (lch == null) ? 0 : ((AVLNode) lch).height;
        int rightHeight = (rch == null) ? 0 : ((AVLNode) rch).height;

        return Math.abs(leftHeight - rightHeight);
    }

    public void updateHeight() {//更新高度
        int leftHeight = (lch == null) ? 0 : ((AVLNode) lch).height;
        int rightHeight = (rch == null) ? 0 : ((AVLNode) rch).height;

        height = Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isLeftNode() {
        return !lch.equals(null);
    }

    public boolean isRightNode() {
        return !rch.equals(null);
    }

    public AVLNode tallerChildNode() {//寻找左右结点中高度最高的结点
        int leftHeight = (lch == null) ? 0 : ((AVLNode) lch).height;
        int rightHeight = (rch == null) ? 0 : ((AVLNode) rch).height;

        if (leftHeight == rightHeight) {
            return isLeftNode() ? lch : rch;
        }
        return (leftHeight > rightHeight) ? lch : rch;
    }


    class avl {
        public AVLNode root;

        public void add(int data) {
            AVLNode template = root;//临时结点，防止破坏根结点的指向
            if (root == null) {
                root = new AVLNode(data);
                return;
            }
            while (true) {
                if (data < template.data) {
                    //找到树的最左端
                    if (template.lch == null) {
                        template.lch = (new AVLNode(data));
                        return;
                    } else {
                        template = template.lch;
                    }
                } else {
                    //找到树的最右端
                    if (template.rch == null) {
                        template.rch = (new AVLNode(data));
                        return;
                    } else {
                        template = template.rch;
                    }
                }
            }

        }

        public void Remove(int data) {
            AVLNode template = root;
            while (true) {
                if (data < template.data) {
                    //找到树的最左端
                    if (template.lch.data == data) {
                        AVLNode Lnode = template.lch;
                        reBalance(Lnode);
                        return;
                    } else {
                        template = template.rch;
                    }
                } else {
                    //找到树的最右端
                    if (template.rch == null) {
                        AVLNode Rnode = template.lch;
                        reBalance(Rnode);
                        return;
                    } else {
                        template = template.rch;
                    }
                }
            }
        }

        private void AfterAdd(AVLNode cur) {
            if (!isBalance(cur)) {
                reBalance(cur);
                cur.updateHeight();
            }
        }

        private void AfterRemove(AVLNode cur) {//删除后恢复平衡
            while ((cur = cur.parent) != null) {
                if (isBalance(cur)) {
                    cur.updateHeight();
                } else {
                    //不同于afterAdd的是恢复平衡后不能直接break 还要判断其他祖先节点是否失衡，直到根节点
                    reBalance(cur);
                }
            }
        }

        private boolean isBalance(AVLNode node) {

            return ((AVLNode) node).balanceFactory() <= 1;
        }

        public void leftrebalance(AVLNode cur) {
            AVLNode lc = cur.lch;

        }

        private void reBalance(AVLNode node) {
            // 获取祖父节点
            AVLNode grand = node;
            // 获取父节点
            AVLNode parent = ((AVLNode) grand).tallerChildNode();
            // 获取子节点
            AVLNode child = ((AVLNode) parent).tallerChildNode();
            if (parent.isLeftNode())// L
            {
                if (child.isLeftNode())// LL 单旋
                {
                    rotateRight(grand);
                } else {// LR 双旋
                    rotateleft(parent);
                    rotateRight(grand);
                }
            } else {
                if (child.isLeftNode())// RL 双旋
                {
                    rotateRight(parent);
                    rotateleft(grand);
                } else {// RR 单旋
                    rotateleft(grand);
                }
            }
        }

        // 左旋转
        public void turnleft(AVLNode cur) {
            AVLNode rc = cur.rch;
            cur.rch = rc.lch;
            rc.lch = cur;
            cur = rc;
        }

        public void rotateleft(AVLNode grand) {
            AVLNode parent = grand.rch;
            AVLNode child = parent.lch;
            parent.lch = grand;
            grand.rch = child;
            //维护父节点的属性
            parent.parent = grand.parent;
            if (grand.isLeftNode()) {
                grand.parent.lch = parent;

            } else if (grand.isRightNode()) {
                grand.parent.rch = parent;

            } else {
                // grand.parent==null
                root = parent;
                // 维护grand的父节点
                grand.parent = parent;
                // 维护child的父节点
                if (child != null) {
                    child.parent = grand;
                }
                // 依次更新高度 从低节点到高节点
                grand.updateHeight();
                parent.updateHeight();
            }
        }

        //无论是左旋或是右旋 始终是针对两个节点(一个祖父节点和一个父节点)来进行操作的
        // 至于child节点是可有可无的。
        // 右旋转

        public void turnright(AVLNode cur) {
            AVLNode lc = cur.lch;
            cur.lch = lc.rch;
            lc.lch = cur;
            cur = lc;
        }

        public void rotateRight(AVLNode grand) {
            AVLNode parent = grand.lch;
            AVLNode child = parent.rch;
            grand.lch = child;
            parent.rch = grand;
            //维护父节点的属性
            parent.parent = grand.parent;
            if (grand.isLeftNode()) {
                grand.parent.lch = parent;

            } else if (grand.isRightNode()) {
                grand.parent.rch = parent;

            } else {
                // grand.parent==null
                root = parent;
                // 维护grand的父节点
                grand.parent = parent;
                // 维护child的父节点
                if (child != null) {
                    child.parent = grand;
                }
                // 依次更新高度 从低节点到高节点
                grand.updateHeight();
                parent.updateHeight();
            }
        }
    }
}


