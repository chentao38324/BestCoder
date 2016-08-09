package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-9.
 * 题目： 输入一棵二叉搜索树，将其转换成一个排序的双向链表
 *          10
 *         /  \
 *        6   14
 *       / |  / |
 *      4  8 12 16
 * 思路：中序遍历，到根节点时，把树看成3部分，值为10的节点，根节点为6的左子树，根节点为14的右子树。
 *      根据排序链表的定义，值为10的节点将和它的左子树的最大一个节点（8）链接起来，同时和右子树最小的节点（12）链接
 *      当我们遍历到根节点（10），它的左子树已经转换成一个排序的链表，并且处在连表的最后一个节点是最大节点（8），
 *      把它和根节点连起来，最大的节点就是10.
 *      接着遍历转换右子树，并把根节点和右子树最小的节点链接。
 *      转换它的左子树和右子树，由于遍历和转换过程都一样，用递归。
 */
public class _27二叉搜索树与双向链表 {

    public static TreeNode convert(TreeNode root){
        TreeNode lastNodeInList = null;
        convertNode(root,lastNodeInList);

        //lastNodeInList是双向链表的尾节点，我们要返回头节点
        TreeNode headOfList = lastNodeInList;
        while (lastNodeInList != null && lastNodeInList.left != null){
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    public static void convertNode(TreeNode node,TreeNode lastNodeInList){
        if (node == null)
            return;
        TreeNode currentNode = node;
        //左子树
        if (currentNode.left != null)
            convertNode(currentNode.left,lastNodeInList);
        currentNode.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = currentNode;
        lastNodeInList = currentNode;
        //右子树
        if (currentNode.right != null)
            convertNode(currentNode.right,lastNodeInList);
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
