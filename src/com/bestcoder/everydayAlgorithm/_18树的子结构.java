package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 * 题目：输入两棵二叉树A 和B，判断B 是不是A 的子结构
 *
 * 思路：要查找树A 中是否存在和树B 结构一样的子树，我们可以分成两步：
 *      第一步在树A 中找到和B 的根结点的值一样的结点R，
 *      第二步再判断树A 中以R 为根结点的子树是不是包含和树B 一样的结构。
 */
public class _18树的子结构 {
    
    public static void main(String[] args){
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(2,node6,node7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(8,node4,node5);
        BinaryTreeNode root1 = new BinaryTreeNode(8,node2,node3);

        BinaryTreeNode node23 = new BinaryTreeNode(2);
        BinaryTreeNode node22 = new BinaryTreeNode(9);
        BinaryTreeNode root2 = new BinaryTreeNode(8,node22,node23);

        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));

        System.out.println("<===========================>");
        System.out.println(root1 == root2);
        System.out.println(node2 == root2);
    }

    //在树1中查找与树根节点值一样的点
    public static boolean hasSubTree(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2){
        if (pRoot2 == null) {
            return true;
        }else if (pRoot1 == null){
            return false;
        }
        boolean result = false;
        if (pRoot1.val == pRoot2.val){
            //如果值相同  做第二步判断
            result = doseTree1HaveTree2(pRoot1,pRoot2);
        }
        if (!result)
            result = hasSubTree(pRoot1.left,pRoot2);
        if (!result)
            result = hasSubTree(pRoot1.right,pRoot2);
        return result;
    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;
        if (pRoot1.val != pRoot2.val)
            return false;

        return doseTree1HaveTree2(pRoot1.left,pRoot2.left) &&
                    doseTree1HaveTree2(pRoot1.right,pRoot2.right);
    }

    private static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(int val){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public BinaryTreeNode(int val,BinaryTreeNode left,BinaryTreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
