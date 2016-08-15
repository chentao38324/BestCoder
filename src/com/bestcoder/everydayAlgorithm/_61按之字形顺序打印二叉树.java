package com.bestcoder.everydayAlgorithm;


import java.util.Stack;

/**
 * Created by chentao on 16-8-14.
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 *      第二层按照从右到左的顺序打印，即第一行按照从左到右的顺序打印，第二层按照从右到左顺序打印，
 *      第三行再按照从左到右的顺序打印，其他以此类推。
 *
 * 思路：用两个栈，在打印某一行节点时，把下一层的子节点保存到相应的栈里。
 *      如果是奇数层，先保存左子节点再保存右子节点到第一个栈；偶数层先右后左到第二个栈，
 *      3.当一层所有节点都打印完了，交换这两个栈继续打印下一层
 */
public class _61按之字形顺序打印二叉树 {

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        print(n1);
    }

    public static void print(BinaryTreeNode root){
        if (root == null)
            return;
        Stack<BinaryTreeNode> curStack = new Stack<>();
        Stack<BinaryTreeNode> nextStack = new Stack<>();
        BinaryTreeNode node;
        int flag = 0;
        curStack.add(root);
        while (curStack.size() > 0){
            node = curStack.pop();
            System.out.print(node.val+" ");
            if (flag == 0){
                if (node.left != null){
                    nextStack.add(node.left);
                }
                if (node.right != null){
                    nextStack.add(node.right);
                }
            }else {
                if (node.right != null){
                    nextStack.add(node.right);
                }
                if (node.left != null){
                    nextStack.add(node.left);
                }
            }
            if (curStack.size() == 0){ //3.
                flag = 1 - flag;
                Stack<BinaryTreeNode> tem = curStack;
                curStack = nextStack;
                nextStack = tem;
                System.out.println();
            }
        }
    }

    private static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        public BinaryTreeNode(int val){
            this.val = val;
        }
    }
}
