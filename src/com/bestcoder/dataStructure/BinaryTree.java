package com.bestcoder.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chentao on 16-8-3.
 * 构建二叉树
 * 法1：
 * 数组构建：将二叉树想成满二叉树，遍历原数组内数 每次从二叉树顶端向下比较，若大于节点往右孩子比较，
 * 若小于等于节点往左孩子比较，
 * 链表构建：定义一个TreeNode类，代表二叉树的一个节点，遍历原始数组，将值加入适当的节点，
 */
public class BinaryTree {
    public static void main(String[] args) {
        //原始数组
        int[] array = new int[]{6,3,5,9,7,8,4,2};
        //树的深度
        int btreeDeepNum = (int)(Math.log((double)(array.length+1))/Math.log((double)2))+1;
        //树的最大节点数
        int btreeNodeNum = (int)Math.pow((double) 2,(double) btreeDeepNum)-1;
        System.out.println("二叉树最大深度："+btreeDeepNum+"\n二叉树最大节点数："+btreeNodeNum);

        //数组构建 并打印
        arrayShow(array,btreeNodeNum);
        //链表构建
        TreeNode rootNode = linkListShow(array);
        //链表构建的二叉树的中序遍历
        System.out.println("\n链表构建的二叉树的中序遍历:");
        inOrder(rootNode);
        //链表构建的二叉树的中序遍历
        System.out.println("\n链表构建的二叉树的前序遍历:");
        preOrder(rootNode);
        //链表构建的二叉树的中序遍历
        System.out.println("\n链表构建的二叉树的后序遍历:");
        postOrder(rootNode);
        //层序遍历
        System.out.println("\n层序遍历:");
        layerOrder(rootNode);
        //层序遍历按层换行
        System.out.println("\n层序遍历按层换行:");
        layerOrderWrap(rootNode);



    }

    /**
     * 数组构建二叉树
     * @param mArray
     * @param mBtreeNodeNum
     */
    private static void arrayShow(int[] mArray, int mBtreeNodeNum) {
        int[] btree = new int[mBtreeNodeNum+1];//非0基开始，从1开始所以+1
        int j ;//btree下标
        for (int i = 0; i < mArray.length; i++) {
            for (j = 1;btree[j] != 0;){ //遍历原数组内数 每次从二叉树顶端向下比较
                if (mArray[i] > btree[j]){
                    j = j*2+1;  //若大于节点往右孩子比较
                }else {
                    j = j*2;    //若小于等于节点往左孩子比较
                }
            }
            btree[j] = mArray[i];
        }
        //打印二叉树
        System.out.println("二叉树内容：");
        for (int i = 1; i < btree.length; i++) {
            System.out.print("["+btree[i]+"]");

        }
    }

    /**
     * 链表构建二叉树
     * 这也就是二叉排序树
     * 中序遍历就是从小到大，若放入栈再pop出就是从大到小了
     * @param array
     */
    public static TreeNode linkListShow(int[] array) {
        TreeNode rootNode = null;  //二叉树根节点
        for (int i = 0; i < array.length; i++) {
            TreeNode currentNode = rootNode;
            //根节点为空 建立根节点并返回
            if (rootNode == null){
                rootNode = new TreeNode(array[i]);
            }else {
                //建立二叉树
                while (true) {
                    if (array[i] > currentNode.value) {
                        //数组中的值大于当前节点的值
                        if (currentNode.rightNode == null) {
                            //且右孩子为空，则该值构成右孩子
                            currentNode.rightNode = new TreeNode(array[i]);
                            break;
                        } else {
                            //否则继续往右孩子比较
                            currentNode = currentNode.rightNode;
                        }
                    } else {
                        //该值小于等于当前值就往左比较 同样的
                        if (currentNode.leftNode == null) {
                            currentNode.leftNode = new TreeNode(array[i]);
                            break;
                        } else {
                            currentNode = currentNode.leftNode;
                        }
                    }
                }
            }
        }
        return rootNode;
    }

    /**
     * 二叉搜索树 的搜索
     * 懂排序就可以理解搜索，只需要在二叉树中比较树根及要搜索的值，再按大小原则递归遍历
     * 二叉搜索树定义：
     * 要么是一棵空树
     * 如果不为空，那么其左子树节点的值“都”小于根节点的值；右子树节点的值“都”大于根节点的值
     * 其左右子树也是二叉搜索树
     * @param node
     * @param value
     * @return
     */
    public static int count = 1;
    public static boolean findTree(TreeNode node,int value){
       if (node == null){
           return false;
       }else if (node.value == value){
           System.out.println("共搜索"+count+"次\n");
           return true;
       }else if (value < node.value){
           count++;
           return findTree(node.leftNode,value);
       }else {
           count++;
           return findTree(node.rightNode,value);
       }
    }

    /**
     * 链表构建的二叉树的 中序遍历 递归实现
     * @param node
     */
    public static void inOrder(TreeNode node){
        if (node != null){
            inOrder(node.leftNode);
            System.out.print("["+node.value+"]");
            inOrder(node.rightNode);
        }
    }

    /**
     * 表构建的二叉树的 前序遍历 递归实现
     * @param node
     */
    public static void preOrder(TreeNode node){
        if (node != null){
            System.out.print("["+node.value+"]");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    /**
     * 表构建的二叉树的 后序遍历 递归实现
     * @param node
     */
    public static void postOrder(TreeNode node){
        if (node != null){
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print("["+node.value+"]");
        }
    }

    /**
     * 层序遍历
     * 用队列实现，先将根节点入队列，开始循环，只要队列不为空，然后出队列并访问，接着将访问节点的左右子树依次入队列
     * @param node
     */
    public static void layerOrder(TreeNode node){
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode tem = queue.poll();
            System.out.print("["+tem.value+"]");
            if (tem.leftNode != null) queue.add(tem.leftNode);
            if (tem.rightNode != null) queue.add(tem.rightNode);
        }
    }

    /**
     * 层序遍历并且按层换行
     * 准备一个队列 , last和nLast变量(TreeNode变量)
     * 思路：首先让last=根节点，然后出队列（现在出的是根节点），
     * 同时将根节点的左右子节点入队列（nLast=左子节点再=右子节点，就是说nLast一直跟随当前新加入的节点，
     * 就是下一行的最右节点）
     * 然后比较last如果==出队列的节点就换行，并令last=nLast.
     * @param node
     */
    public static void layerOrderWrap(TreeNode node){
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = node;             //当前行最右节点
        TreeNode nLast = null;            //目前下一行最右的节点
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode tem = queue.poll();
            System.out.print(tem.value);
            if (tem.leftNode != null) {
                queue.add(tem.leftNode);
                nLast = tem.leftNode;
            }
            if (tem.rightNode != null) {
                queue.add(tem.rightNode);
                nLast = tem.rightNode;
            }
            if (last == tem){
                System.out.println();
                last = nLast;
            }else {
                System.out.print(" ");
            }
        }
    }

    /**
     * 二叉树的节点类
     */
    private static class TreeNode {
        int value;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int data){
            this.value = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
}
