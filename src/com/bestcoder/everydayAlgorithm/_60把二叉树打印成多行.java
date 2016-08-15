package com.bestcoder.everydayAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chentao on 16-8-15.
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印一行。
 * 层序遍历
 * 准备一个队列 , last和nLast变量(TreeNode变量)
 * 思路：首先让last=根节点，然后出队列（现在出的是根节点），
 * 同时将根节点的左右子节点入队列（nLast=左子节点再=右子节点，就是说nLast一直跟随当前新加入的节点，
 * 就是下一行的最右节点）
 * 然后比较last如果==出队列的节点就换行，并令last=nLast.
 */
public class _60把二叉树打印成多行 {

    public static void print(BinaryTreeNode root){
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode last = root;
        BinaryTreeNode nLast = null;
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode tem = queue.poll();
            System.out.print(tem.val);
            if (tem.left != null){
                queue.add(tem.left);
                nLast = tem.left;
            }
            if (tem.right != null){
                queue.add(tem.right);
                nLast = tem.right;
            }
            if (last == tem){
                System.out.println();
                last = nLast;
            }else {
                System.out.print(" ");
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

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;

        print(n1);

    }
}
