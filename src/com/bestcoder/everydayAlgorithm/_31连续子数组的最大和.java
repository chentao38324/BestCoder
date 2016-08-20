package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-10.
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 *      求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 * 思路：用一个int记录最大的子数组和
 *
 * 方法2：动态规划
 */
public class _31连续子数组的最大和 {

    private static boolean gInvalidInput = false;
    public static void main(String[] args){
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int result = findGreatestSumOfSubArray(array);
        System.out.println(result);
    }

    public static int findGreatestSumOfSubArray(int[] array){
        if (array == null || array.length == 0) {
            gInvalidInput = true;
            return 0;
        }
        gInvalidInput = false;
        int currentSum = array[0];
        int greatestSum = currentSum;
        for (int i = 1; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum < 0){
                currentSum = 0;
            }
            if (currentSum > greatestSum){
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }
}
