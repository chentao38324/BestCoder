package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-14.
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。 和6_3一样
 */
public class _62序列化二叉树 {

    public static void main(String[] args){
        String str = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        BinaryTreeNode root = deSerialize(str);
        String result = serialize(root);
        System.out.println(result);
    }
    public static String serialize(BinaryTreeNode root){
        if (root == null)
            return "$,";
        StringBuffer sb = new StringBuffer();
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    private static int index = -1;
    public static BinaryTreeNode deSerialize(String str){
        index++;
        int len = str.length();
        if (index > len) {
            return null;
        }
        BinaryTreeNode node = null;
        String[] strArray = str.split(",");
        if (!strArray[index].equals("$")) {
            node = new BinaryTreeNode(Integer.valueOf(strArray[index]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
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
