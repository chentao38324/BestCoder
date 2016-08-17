package com.bestcoder.everydayAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chentao on 16-8-8.
 * 就是层序遍历 -- 利用队列先入先出
 *
 * 广度优先遍历（BFS），不管是树还是图，都用到队列。
 * 第一步把起始点放入队列，
 * 接下来每一次从队列的头部取出一个节点，遍历访问这个节点之后把从它能到达的节点都依次放入队列，
 * 重复这个遍历过程，知道队列中的节点全部被遍历为止
 */
public class _23从上往下打印二叉树 {

    public static void printFromTopToBottom(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
