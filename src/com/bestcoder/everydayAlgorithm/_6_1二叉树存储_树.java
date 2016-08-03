package com.bestcoder.everydayAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chentao on 16-8-3.
 * 牛课堂的算法题
 * 层序遍历二叉树 并转换成二维数组返回
 */
class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;
    public TreeNode1(int val) {
        this.val = val;
    }
}
public class _6_1二叉树存储_树 {
    public static void main(String[] args) {
        int[] array = new int[]{6,3,5,9,7,8,4,2};
        TreeNode1 rootNode = linkListShow(array);
        /**
         * 除了下面这行其他都是构建链表 打印等
         */
        int[][] result = printTree(rootNode);

        System.out.print("{");
        for (int i = 0; i < result.length; i++) {
            System.out.print("{");
            for (int j = 0; j < result[i].length; j++) {
                if (j == result[i].length -1 )
                    System.out.print(result[i][j]);
                else
                    System.out.print(result[i][j]+",");
            }
            if (i == result.length - 1)
                System.out.print("}");
            else
                System.out.print("},");
        }
        System.out.print("}");
    }
    /**
     * 链表构建二叉树 不是本题重点
     * @param array
     */
    private static TreeNode1 linkListShow(int[] array) {
        TreeNode1 rootNode = null;  //二叉树根节点
        for (int i = 0; i < array.length; i++) {
            TreeNode1 currentNode = rootNode;
            //根节点为空 建立根节点并返回
            if (rootNode == null){
                rootNode = new TreeNode1(array[i]);
            }else {
                //建立二叉树
                while (true) {
                    if (array[i] > currentNode.val) {
                        //数组中的值大于当前节点的值
                        if (currentNode.right == null) {
                            //且右孩子为空，则该值构成右孩子
                            currentNode.right = new TreeNode1(array[i]);
                            break;
                        } else {
                            //否则继续往右孩子比较
                            currentNode = currentNode.right;
                        }
                    } else {
                        //该值小于等于当前值就往左比较 同样的
                        if (currentNode.left == null) {
                            currentNode.left = new TreeNode1(array[i]);
                            break;
                        } else {
                            currentNode = currentNode.left;
                        }
                    }
                }
            }
        }
        return rootNode;
    }

    /**
     * 本题重点 方法
     * @param root 二叉树根节点
     * @return 二维数组
     * 思路：其实就是在层序遍历的基础上改了下
     *
     */
    public static int[][] printTree(TreeNode1 root) {
        // write code here
        Queue<TreeNode1> queue = new LinkedList<>();
        TreeNode1 last = root;
        TreeNode1 nLast = root;
        List<Integer> layerSaveList = new ArrayList<>();
        int i = 0;
        List<List<Integer>> allSaveList = new ArrayList<>();
        int j = 0;
        int[][] allSave;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode1 tem = queue.poll();
            layerSaveList.add(i++,tem.val);
            if(tem.left != null){
                queue.add(tem.left);
                nLast = tem.left;
            }
            if(tem.right != null){
                queue.add(tem.right);
                nLast = tem.right;
            }
            if(tem == last){
                allSaveList.add(j++,layerSaveList);
                //下面两行重置每层的list
                layerSaveList = new ArrayList<>();
                i = 0;
                last = nLast;
            }
        }
        //将list转成数组
        allSave = new int[allSaveList.size()][];
        List<Integer> tem;
        for(int k = 0;k<allSaveList.size();k++){
            tem = allSaveList.get(k);
            allSave[k] = new int[tem.size()];
            for (int l = 0; l < tem.size(); l++) {
                allSave[k][l] = tem.get(l);
            }
        }
        return allSave;
    }

    /**
     * 牛客网上别人的答案
     */
    /*public int[][] printTree(TreeNode root) {
        // write code here
        List<List<Integer>> result=new ArrayList<>();
        List<TreeNode> level=new ArrayList<>();
        level.add(root);
        while(true){
            List<Integer> list=new ArrayList<>();
            List<TreeNode> newlevel=new ArrayList<>();
            for(TreeNode node:level){
                list.add(node.val);
                if(node.left!=null)
                    newlevel.add(node.left);
                if(node.right!=null)
                    newlevel.add(node.right);
            }
            result.add(list);
            level=new ArrayList<>(newlevel);
            if(level.isEmpty())
                break;
        }
        int[][]num=new int[result.size()][];
        for(int i=0;i<result.size();i++){
            num[i]=new int[result.get(i).size()];
            for(int j=0;j<num[i].length;j++){
                num[i][j]=result.get(i).get(j);
            }
        }
        return num;
    }*/
}
