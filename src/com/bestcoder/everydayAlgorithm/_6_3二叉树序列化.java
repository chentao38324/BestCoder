package com.bestcoder.everydayAlgorithm;


/**
 * Created by chentao on 16-8-3.
 * 二叉树的序列化和反序列化  使用先序遍历示范
 */
public class _6_3二叉树序列化 {

    public static void main(String[] args) {
        _6_3二叉树序列化 instant = new _6_3二叉树序列化();
        //根据字符串反序列化二叉树
        String str = "12!3!#!#!#!";
        TreeNode node = instant.deserialization(str);
        //序列化
        String string = serialize(node);
        System.out.println(string);
    }

    private static String serialize(TreeNode root) {
        if (root == null){
            return "#!";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val+"!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public int index = -1;
    private TreeNode deserialization(String str) {
        index++;
        int len = str.length();
        if (index >= len){
            return null;
        }
        TreeNode node = null;
        String[] strArray = str.split("!");
        if (!strArray[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strArray[index]));
            node.left = deserialization(str);
            node.right = deserialization(str);
        }
        return node;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}


