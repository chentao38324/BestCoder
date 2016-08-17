package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-8.
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 思路：前序遍历二叉树 遇到每个非叶子节点就交换它的两个子节点
 */
public class _19二叉树的镜像 {

    public static void mirrorBTree(BinaryTreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        BinaryTreeNode temNode = root.left;
        root.left = root.right;
        root.right = temNode;
        if (root.left != null)
            mirrorBTree(root.left);
        if (root.right != null)
            mirrorBTree(root.right);
    }

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
