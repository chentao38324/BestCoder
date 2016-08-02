package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-1.
 */
public class _4_1排序数组合并 {
    public static int[] sortArray(int[] array1,int[] array2){
        int len1 = array1.length;
        int len2 = array2.length;
        //计算合并后数组长度
        int resultLength = len1 + len2;
        int[] resultArray = new int[resultLength];
        int j = len1-1;
        int k = len2-1;
        int l = resultLength-1;
        while (j>=0 && k>=0) {
            if (array1[j] > array2[k]){
                resultArray[l--] = array1[j];
                j--;
            }else {
                resultArray[l--] = array2[k];
                k--;
            }
        }
        //把剩下每排完的放进去
        if (j == -1) {
            for (int i = k; i >= 0; i--) {
                resultArray[l--] = array2[k--];
            }
        }else {
            for (int i = j; i >= 0; i--) {
                resultArray[l--] = array1[j--];
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{4,6,8,10,12};
        int[] array2 = new int[]{2,3,9};
        int[] result = sortArray(array1,array2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }
}
