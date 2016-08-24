package com.bestcoder.everydayAlgorithm;


/**
 * Created by chentao on 16-8-11.
 * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）
 *       形成树的一条路径，最长路径的长度为树的深度。
 *
 *       可以根据25题中得到树的所有路径，最长的就是深度  代码量大 不简洁
 *
 *  思路：如果一棵树只有一个结点，它的深度为。 如果根结点只有左子树而没有右子树，
 *       那么树的深度应该是其左子树的深度加1，同样如果根结点只有右子树而没有左子树，
 *       那么树的深度应该是其右子树的深度加1. 如果既有右子树又有左子树， 那该树的深度就是其左、
 *       右子树深度的较大值再加1 .
 *       即：树的深度==左右子树深度较大的值+1
 *       这个思路用递归的方法很容易实现， 只需对遍历的代码稍作修改即可。
 *
 * 题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树的深度相差不超过1 ，
 *       那么它就是一棵平衡二叉树。
 *   解法一：需要重复遍历结点多次的解法
 *         在遍历树的每个结点的时候，调用函数treeDepth得到它的左右子树的深度。如果每个结点的左右子树的深度相差都不超过1，
 *         按照定义它就是一棵平衡的二叉树。
 *   解法二：每个结点只遍历一次的解法
 *         用后序遍历的方式遍历二叉树的每一个结点，在遍历到一个结点之前我们就已经遍历了它的左右子树。
 *         只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶节点的路径的长度），
 *         我们就可以一边遍历一边判断每个结点是不是平衡的。
 */
public class _39二叉树的深度 {
    public static void main(String[] args){

    }
    //题目一：
    public int treeDepth(BinaryTreeNode root){
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left+1 : right+1;
    }


    //题目二：
    //解法一：需要重复遍历结点多次的解法
    public boolean isBalance(BinaryTreeNode root){
        if (root == null){
            return false;
        }
        int left = treeDepth(root);
        int right = treeDepth(root);
        int diff = left - right;
        if (diff < -1 || diff > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    //解法二：
    public static boolean isBalanced(BinaryTreeNode root){
        int[] depth = new int[1];
        return isBalanced(root,depth);
    }

    public static boolean isBalanced(BinaryTreeNode root,int[] depth){
        if (root == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];

        if (isBalanced(root.left,left) && isBalanced(root.right,right)){
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1){
                depth[0] = 1+(left[0] > right[0] ?left[0] : right[0]);
                return true;
            }
        }
        return false;
    }

    private class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
}
