package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 */
public class _18树的子结构 {
    public boolean hasSubTree(TreeNode pRoot1,TreeNode pRoot2){
        if (pRoot1 == null || pRoot2 == null)
            return false;
        boolean result = false;
        if (pRoot1.val == pRoot2.val){
            result = doseTree1HaveTree2(pRoot1,pRoot2);
        }
        if (!result)
            result = hasSubTree(pRoot1.left,pRoot2);
        if (!result)
            result = hasSubTree(pRoot1.right,pRoot2);
        return result;
    }

    private boolean doseTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;
        if (pRoot1.left.val != pRoot2.left.val)
            return false;

        return doseTree1HaveTree2(pRoot1.left,pRoot2.left) &&
                    doseTree1HaveTree2(pRoot1.right,pRoot2.right);
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
