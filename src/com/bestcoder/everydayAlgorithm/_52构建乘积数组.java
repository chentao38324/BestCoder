package com.bestcoder.everydayAlgorithm;

import java.util.Arrays;

/**
 * Created by chentao on 16-8-13.
 * 题目：给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],
 *      其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法。
 *
 * 直观的方法是连乘n-1个数字  O(n²)
 *
 * 思路：把B[i]看成=A[0]×A[1]×…×A[i-1]和A[i+1]×…×A[n-1]两部分乘积，因此数组B可用一个二维矩阵来创建
 *      对角线 左上到右下 为1 B[i]为矩阵中第i行所有元素乘积 那两部分乘积分别为C[i]和D[i]
 *      C[i] = C[i-1]*A[i-1]   D[i] = D[i+1]*A[i+1]
 *
 *      时间复杂度O(n)
 */
public class _52构建乘积数组 {

    public static void main(String[] args) {
        double[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(array1))); // double expected[] = {120, 60, 40, 30, 24};
        double[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(multiply(array2))); // double expected[] = {0, 0, 40, 0, 0};
        double[] array3 = {1, 2, 0, 4, 0};
        System.out.println(Arrays.toString(multiply(array3))); // double expected[] = {0, 0, 0, 0, 0};
        double[] array4 = {1, -2, 3, -4, 5};
        System.out.println(Arrays.toString(multiply(array4))); // double expected[] = {120, -60, 40, -30, 24};
        double[] array5 = {1, -2};
        System.out.println(Arrays.toString(multiply(array5))); // double expected[] = {-2, 1};
    }

    public static double[] multiply(double[] data){
        if (data == null || data.length < 2){
            return null;
        }
        int len = data.length;
        double[] result = new double[len];
        result[0] = 1; //左上角那里初始化为1
        //先计算C[i] 赋值给结果
        for (int i = 1; i < len; i++) {
            result[i] = result[i-1] * data[i-1];
        }
        //再计算D[i]
        int tem = 1;
        for (int i = len-2; i >= 0 ; i--) {
            tem *= data[i+1];
            result[i] *= tem;
        }
        return result;
    }
}
