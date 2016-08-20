package com.bestcoder.everydayAlgorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao on 16-8-8.
 * 题目：输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。
 *      从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，
 * 因此我们首先需要遍历根结点。用前序遍历。
 *
 * 当用前序遍历的方式访问到某一结点时， 我们把该结点添加到路径上，并累加该结点的值。
 * 如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数， 则当前的路径符合要求，我们把它打印出来。
 * 如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。
 * 因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。
 *
 * 不难看出保存路径的数据结构实际上是一个栈， 因为路径要与递归调用状态一致， 而递归调用的本质就是一个压栈和出栈的过程。
 */
public class _25二叉树中和为某一值的路径 {
    public static void main(String[] args){
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node1 = new BinaryTreeNode(5,node3,node4);
        BinaryTreeNode root = new BinaryTreeNode(10,node1,node2);

        findPath(root,22);
    }

    public static void findPath(BinaryTreeNode root,int expectedSum){
        if (root == null)
            return;
        List<Integer> path = new ArrayList<>();
        int currentSum = 0;
        findPath(root,expectedSum,path,currentSum);
    }

    private static void findPath(BinaryTreeNode root, int expectedSum, List<Integer> path, int currentSum) {
        currentSum += root.val;
        path.add(root.val);
        //当前和等于期望和 并且是叶子节点 打印路径
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf){
            System.out.println(path);
        }
        if (root.left != null)
            findPath(root.left,expectedSum,path,currentSum);
        if (root.right != null)
            findPath(root.right,expectedSum,path,currentSum);
        path.remove(path.size()-1);
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
        public BinaryTreeNode(int val,BinaryTreeNode left,BinaryTreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
