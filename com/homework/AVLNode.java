package com.homework;

/**
 * 平衡二叉树实现
 */
public class AVLNode {
    private AVLNode left;

    private AVLNode right;

    private Integer value;

    private int height;

    public AVLNode(Integer value) {
        this(value, null, null, 0);
    }

    public AVLNode(AVLNode node) {
        this.value = node.value;
        this.left = node.left;
        this.right = node.right;
        this.height = node.height;
    }

    public AVLNode(Integer value, AVLNode left, AVLNode right, int height) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    //插入操作
    public AVLNode insert(AVLNode node, int value) {
        if (node == null) {
            node = new AVLNode(value);
        } else {
            if (value < node.value) {
                node.left = insert(node.left, value);
                if (getHeight(node.left) - getHeight(node.right) == 2) {
                    if (value < node.left.value) {
                        node = singleLeftRotation(node);
                    } else if (value > node.left.value) {
                        node = DoubleLeftRightRotation(node);
                    }
                }
            } else if (value > node.value) {
                node.right = insert(node.right, value);
                if (getHeight(node.left) - getHeight(node.right) == -2) {
                    if (value > node.right.value) {
                        node = singleRightRotation(node);
                    } else if (value < node.right.value) {
                        node = DoubleRightLeftRotation(node);
                    }
                }
            }
            updateHeight(node);
        }
        return node;
    }

    public AVLNode find(int value) {
        if (this == null) return null;
        AVLNode node = this;
        while (node != null) {
            if (node.value == value) {
                return node;
            } else if (value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private AVLNode delete(int value) {
        return delete(this, value);
    }

    /**
     * 递归查找后删除节点
     *
     * @return
     */
    private AVLNode delete(AVLNode node, int value) {
        if (node.value == value) {
            node = removeNode(node);
        } else {
            if (value < node.value) {
                node.left = delete(node.left, value);
                //实际上删除左子树上节点导致不平衡只有两种情况‘
                // 1、删除后当前节点要单右旋
                //2、删除后当前节点要左右旋
                if (getHeight(node.left) - getHeight(node.right) == -2) {
                    if (node.right.left == null) {
                        node = singleRightRotation(node);
                    } else {
                        node = DoubleRightLeftRotation(node);
                    }
                }
            } else if (value > node.value) {
                node.right = delete(node.right, value);
                if (getHeight(node.left) - getHeight(node.right) == 2) {
                    if (node.left.right == null) {
                        node = singleLeftRotation(node);
                    } else {
                        node = DoubleLeftRightRotation(node);
                    }
                }
            }
            updateHeight(node);
        }
        return node;
    }

    /**
     * 节点删除
     *
     * @param node
     * @return
     */
    private AVLNode removeNode(AVLNode node) {
        //删除的节点为叶子节点
        if (node.left == null && node.right == null) {
            node = null;
        } else if (node.left == null || node.right == null) { //删除的节点只有左子树或者是右子树
            if (node.left == null) {
                node = node.right;
            } else {
                node = node.left;
            }
        } else { //删除的节点既有左子树又有右子树（需要获取左子树的最大节点或者右子树的最小节点替换）
            /**
             * 1、获取左子树最大节点的父节点
             * 2、获取父节点的右节点
             * 3、如果没有右节点，那么取父节点未左子树最大节点
             */
            AVLNode leftChrildMaxParent = getLeftChrildMax(node.left);
            AVLNode leftChrildMax = leftChrildMaxParent.right;
            if (leftChrildMax == null) {
                leftChrildMax = leftChrildMaxParent;
                leftChrildMax.right = node.right;
            } else {
                leftChrildMax.left = node.left;
                leftChrildMax.right = node.right;
                leftChrildMaxParent.right = null;
            }
            node = leftChrildMax;

        }
        return node;
    }

    private AVLNode getLeftChrildMax(AVLNode node) {
        if (node == null) {
            return null;
        }
        AVLNode parentNode = node;
        AVLNode chrildNode = parentNode.right;
        while (chrildNode != null) {
            if (chrildNode.right != null) {
                parentNode = chrildNode;
                chrildNode = chrildNode.right;
            } else {
                break;
            }

        }
        return parentNode;
    }

    /**
     * 平衡二叉树调整方法
     *
     * @param node
     * @return
     */
    private AVLNode reviseNode(AVLNode node) {
        if (node == null) {
            return null;
        } else {
            node.left = reviseNode(node.left);
            node.right = reviseNode(node.right);
            if (getHeight(node.left) - getHeight(node.right) == 2) {
                if (node.left.right == null) {
                    node = singleLeftRotation(node);
                } else {
                    node = DoubleLeftRightRotation(node);
                }
            } else if (getHeight(node.left) - getHeight(node.right) == -2) {
                if (node.right.left == null) {
                    node = singleRightRotation(node);
                } else {
                    node = DoubleRightLeftRotation(node);
                }
            }
            updateHeight(node);
            return node;
        }
    }

    private AVLNode DoubleLeftRightRotation(AVLNode A) {
        A.left = singleRightRotation(A.left);
        return singleLeftRotation(A);
    }

    public AVLNode DoubleRightLeftRotation(AVLNode A) {
        A.right = singleLeftRotation(A.right);
        return singleRightRotation(A);
    }

    private AVLNode singleLeftRotation(AVLNode A) {
        AVLNode B = A.left;
        A.left = B.right;
        B.right = A;
        A.height = Math.max(getHeight(A.left), getHeight(A.right)) + 1;
        B.height = Math.max(getHeight(B.left), A.height) + 1;
        return B;
    }

    private AVLNode singleRightRotation(AVLNode A) {
        AVLNode B = A.right;
        A.right = B.left;
        B.left = A;
        A.height = Math.max(getHeight(A.left), getHeight(A.right)) + 1;
        B.height = Math.max(getHeight(B.right), A.height) + 1;
        return B;
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public void toString(AVLNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        toString(node.left);
        toString(node.right);
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return -1;
        } else {
            int leftH = getHeight(node.left);
            int rightH = getHeight(node.right);
            return Math.max(leftH, rightH) + 1;
        }
    }

    private void updateHeight(AVLNode node) {
        node.height = getHeight(node);
    }
}


