package com.bestcoder.everydayAlgorithm;

import java.util.Arrays;

/**
 * Created by chentao on 16-8-8.
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历的结果，
 *      假设输入的数组任意两个数字都不相同
 *
 * 思路：
 */
public class _24二叉搜索树的后序遍历 {
    public static void main(String[] args){
        int[] array = {7,4,6,5};

        System.out.println(verifySquenceOfBST(null)+"");
    }

    public static boolean verifySquenceOfBST(int[] sequence){
        if (sequence == null)
            return false;
        int len = sequence.length;
        if (len <= 0)
            return false;
        int root = sequence[len-1]; //最后一个数字 是根节点

        int i;
        for (i=0;i<len-1;i++){
            if (sequence[i] > root)
                break;
        }
        for (int j = i; j < len-1; j++) {
            if (sequence[j] < root)
                return false;
        }
        //构造左右子树的数组
        int[] leftArray = Arrays.copyOfRange(sequence,0,i);
        int[] rightArray = Arrays.copyOfRange(sequence,i,len-1);
        //判断左子树是不是BST
        boolean left = true;
        if (i > 0){
            left = verifySquenceOfBST(leftArray);
        }
        boolean right = true;
        if (i<len-1){
            right = verifySquenceOfBST(rightArray);
        }
        return (left && right);
    }
}
