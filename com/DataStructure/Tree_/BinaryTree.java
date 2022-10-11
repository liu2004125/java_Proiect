package com.DataStructure.Tree_;

public class BinaryTree {
    public static void main(String[] args) {
        int[] data = new int[]{23, 4, 78, 101, 11, 22, 54, 67, 55, 94};
        Tree tree = new Tree(data);
        System.out.println("树的前序");
        tree.Preorder(tree.rootnode);
        System.out.println();
        System.out.println("树的中序遍历");
        tree.Inorder(tree.rootnode);
        System.out.println();
        System.out.println("树的后序遍历");
        tree.Lastorder(tree.rootnode);
        System.out.println();
        System.out.println("删除67");
        tree.remove(7);
        System.out.println("前序输出");
        tree.Preorder(tree.rootnode);
        System.out.println();
        System.out.println("插入8");
        tree.add(8);
        System.out.println("前序输出");
        tree.Preorder(tree.rootnode);
    }
}

class TreeNode { // 结点的结构
    private TreeNode lnode, rnode;//z左右孩子指针
    private int data;//数据

    public TreeNode(int data) {
        this.lnode = null;
        this.rnode = null;
        this.data = data;
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

    public void setData(int data) {
        this.data = data;
    }
}

class Tree {
    public TreeNode rootnode;//根结点

    public Tree(int[] value) {
        for (int i = 0; i < value.length; i++) {
            add(value[i]);
        }
    }

    private void balanceL(TreeNode cur, TreeNode pre) {//平衡由父节点的左孩子
        //找到左子树的最右结点替换它（左子树的最大结点）
        TreeNode parent = cur;
        TreeNode temp = cur;
        if (cur.getRnode() == null) {//如果操作结点没有右子树
            pre.setLnode(cur.getLnode());//将父节点接入操作结点的左子树
        } else if (cur.getLnode() == null) {//如果操作结点没有左子树
            pre.setLnode(cur.getRnode());//同理
        } else {//左右子树皆存在
            temp = cur.getLnode();//临时结点为左孩子
            while (temp.getRnode() != null) {//如果有右孩子
                parent = temp;//保存前驱结点
                temp = temp.getRnode();//向右前进
            }
            //直到最右端的结点
            cur.setData(temp.getData());
            if (parent == cur)
                parent.setLnode(temp.getLnode());
            else//使得被替换的结点为空，将其前驱结点指向null
                parent.setRnode(temp.getLnode());
        }
    }

    private void balanceR(TreeNode cur, TreeNode pre) {
        //找到右子树的最左结点替换它（右子树的最小结点）
        TreeNode parent = cur;
        TreeNode temp = cur;
        if (cur.getRnode() == null) {
            pre.setRnode(cur.getLnode());
        } else if (cur.getLnode() == null) {
            pre.setRnode(cur.getRnode());
        } else {
            temp = cur.getLnode();//临时结点为左孩子
            while (temp.getRnode() != null) {//如果有右孩子
                parent = temp;//保存前驱结点
                temp = temp.getRnode();//向右前进
            }
            //直到最右端的结点
            cur.setData(temp.getData());
            if (parent == cur)
                parent.setLnode(temp.getLnode());
            else//使得被替换的结点为空，将其前驱结点指向null
                parent.setRnode(temp.getLnode());
        }
    }

    public void remove_book(int data) {

    }

    public void remove(int data) {
        TreeNode template = rootnode;
        TreeNode pre = rootnode;
        while (true) {
            if (data < template.getData()) {
                //找到树的左端
                if (template.getLnode() == null) {
                    System.out.println("查无此数");
                    return;
                } else if (template.getLnode().getData() == data) {//如果匹配
                    TreeNode Lnode = template.getLnode();//Lnode是需要修改的结点，template是其父节点
                    balanceL(Lnode, template);//属性维护操作
                    return;
                } else {
                    pre = template;//保留前驱
                    template = template.getLnode();//向左走
                }
            } else {
                //找到树的最右端
                if (template.getRnode() == null) {
                    System.out.println("查无此数");
                    return;
                } else if (template.getRnode().getData() == data) {//与左结点同理
                    TreeNode Rnode = template.getRnode();
                    balanceR(Rnode, template);
                    return;
                } else {
                    pre = template;
                    template = template.getRnode();
                }
            }
        }
    }

    public void add(int data) {
        TreeNode template = rootnode;//临时结点，防止破坏根结点的指向
        if (rootnode == null) {//第一个结点则建立树根
            rootnode = new TreeNode(data);
            return;
        }
        while (true) {
            if (data < template.getData()) {//比父节点小，放左边
                //找到树的左端
                if (template.getLnode() == null) {
                    TreeNode child = new TreeNode(data);
                    template.setLnode(child);
                    return;
                } else {
                    template = template.getLnode();
                }
            } else {
                //找到树的右端
                if (template.getRnode() == null) {
                    TreeNode child = new TreeNode(data);
                    template.setRnode(child);
                    return;
                } else {
                    template = template.getRnode();
                }
            }
        }
    }

    public void Preorder(TreeNode node) {//前序遍历
        if (node == null) return;
        System.out.print(node.getData() + ",");
        Preorder(node.getLnode());
        Preorder(node.getRnode());

    }

    public void Inorder(TreeNode node) {//中序遍历
        if (node == null) return;
        Inorder(node.getLnode());
        System.out.print(node.getData() + ",");
        Inorder(node.getRnode());

    }

    public void Lastorder(TreeNode node) {//后序遍历
        if (node == null)
            return;
        Lastorder(node.getLnode());
        Lastorder(node.getRnode());
        System.out.print(node.getData() + ",");
    }
}

