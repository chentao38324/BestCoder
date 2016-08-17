package com.bestcoder.everydayAlgorithm;


/**
 * Created by chentao on 16-8-3.
 * 已知前序遍历和中序遍历，重建该二叉树（若已知后序和中序也可以，已知前序和后序则不行，有多种，不唯一）
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 思路：从前序遍历中知道第一个就是根节点;然后在中序遍历中找到这个根节点;则中序遍历中根节点左边的是左子树，
 * 右边的是右子树,构建左右子树，(使根节点的left=左子树的根节点，right=右子树的根节点)
 * 再对左右子树同样的操作，使用递归。
 */
public class _6重建二叉树_树 {
    public static void main(String[] args){
        //前序遍历序列
        int[] preOrder = {1,2,4,7,3,5,6,8};
        //中序遍历序列
        int[] inOrder = {4,7,2,1,5,3,8,6};
        TreeNode root = constructCore(preOrder,inOrder);
        System.out.println("后续遍历：");
        postOrder(root);
    }

    private static TreeNode constructCore(int[] preOrder, int[] inOrder) {
        //从前序遍历找到根节点
        TreeNode root = new TreeNode(preOrder[0],null,null);
        int leftNum = 0;
        //在中序遍历中找到根节点
        for (int i = 0; i < inOrder.length; i++) {
            if (root.value == inOrder[i]){
                break;
            }else {
                leftNum++;
            }
        }
        int rightNum = inOrder.length - leftNum - 1;

        //构建左子树
        if (leftNum > 0){
            int[] leftTreePreOrder = new int[leftNum];
            int[] leftTreeInOrder = new int[leftNum];
            for (int i = 0; i < leftNum; i++) {
                leftTreePreOrder[i] = preOrder[i+1];
                leftTreeInOrder[i] = inOrder[i];
            }
            TreeNode leftRoot = constructCore(leftTreePreOrder,leftTreeInOrder);
            root.leftNode = leftRoot;
        }

        //构建右子树
        if (rightNum > 0){
            int[] rightTreePreOrder = new int[rightNum];
            int[] rightTreeInOrder = new int[rightNum];
            for (int i = 0; i < rightNum; i++) {
                rightTreePreOrder[i] = preOrder[1+leftNum+i];
                rightTreeInOrder[i] = inOrder[leftNum+1+i];
            }
            TreeNode rightRoot = constructCore(rightTreePreOrder,rightTreeInOrder);
            root.rightNode = rightRoot;
        }
        return root;
    }

    private static void postOrder(TreeNode node) {
        if (node != null){
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print("["+node.value+"]");
        }
    }

    private static class TreeNode {
        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int value){
            this.value = value;
        }
        public TreeNode(int value,TreeNode leftNode,TreeNode rightNode){
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }
}


