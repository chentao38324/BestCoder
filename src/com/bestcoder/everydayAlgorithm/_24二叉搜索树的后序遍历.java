package com.bestcoder.everydayAlgorithm;

import java.util.Arrays;

/**
 * Created by chentao on 16-8-8.
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *      如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：在后序遍历得到的序列中， 最后一个数字是树的根结点的值。数组中前面的数字可以分为两部分：
 *      第一部分是左子树结点的值，它们都比根结点的值小；第二部分是右子树结点的值，它们都比根结点的值大。
 *      (第二部分有<根节点的 返回false)
 *      分出左右子树 递归的判断
 */
public class _24二叉搜索树的后序遍历 {
    public static void main(String[] args){
        int[] array = {7,4,6,5};

        System.out.println(verifySquenceOfBST(array)+"");
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
                return false; //第二部分有<根节点的 返回false
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
