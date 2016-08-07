package com.bestcoder.confusionCode;

/**
 * Created by chentao on 16-4-20.
 */
public class 一站通offer三 {

    public static void main(String[] args){
//        findPath()
    }

    static int maxLength = 0;
    public static int findPath(TreeNode root) {
        order(root);
        if (root == null)
        return 0;
        else
        return maxLength;
        }
    public static int order(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
            } else {
            int leftLength = order(root.left);
            int rightLength = order(root.right);
            int length = 1;
            if (root.left == null && root.right == null) {
                length = 1;
                maxLength = Math.max(length, maxLength);
                }
            else {
                if (root.left != null && root.val == root.left.val)
                length += leftLength;
                if (root.right != null && root.val == root.right.val)
                length = Math.max(length, 1 + rightLength);
                if (root.left == null || root.right == null) {
                    maxLength = Math.max(length, maxLength);
                    } else {
                    if (root.right.val == root.left.val && root.val == root.left.val)
                    maxLength = Math.max(maxLength, leftLength + rightLength + 1);
                    else
                    maxLength = Math.max(length, maxLength);
                    }
                }
            return length;
            }
        }
    private static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        public TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }

    }
}

