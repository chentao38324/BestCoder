package com.bestcoder.everydayAlgorithm;


/**
 * Created by chentao on 16-8-11.
 * 输入根节点 求深度
 * 可以根据25题中得到树的所有路径，最长的就是深度  代码量大 不简洁
 *
 * 思路：树的深度==左右子树深度较大的值+1
 */
public class _39二叉树的深度 {
    public static void main(String[] args){

    }

    public int treeDepth(BinaryTreeNode root){
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left+1 : right+1;
    }

    private class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
}
