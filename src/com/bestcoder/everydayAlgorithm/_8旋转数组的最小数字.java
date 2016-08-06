package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 旋转数组：将一个有序数组的前部分n个元素整体移动到数组后面 比如12345 旋转数组可以为 34512
 * 思路：二分查找 用两个指针i，j分别在两端，mid为中间索引 每次比较mid的值和 i，j。
 * >i，说明mid在mid在前边数组使 i=mid；<j,说明mid在后面数组 使 j=mid
 * 注意：n=0 还是有序数组  i，j，mid相等的情况
 */
public class _8旋转数组的最小数字 {
    public static void main(String[] args){
        int[] array = {1,0,1,1,1};
        System.out.println("最小数字："+minNumber(array));
    }

    public static int minNumber(int[] data){
        int i = 0;  //第一个索引
        int j = data.length-1;  //最后一个索引
        int mid = i;
        while (data[i] >= data[j]){
            if (i+1 == j){
                mid = j;
                break;
            }
            mid = (i+j)/2;
            //如果i，j，mid下标指向的数字都一样，只能顺序查找了
            if (data[i] == data[j] && data[j] == data[mid]){
                return minInOrder(data,i,j);
            }
            if (data[mid] > data[i]){
                i = mid;
            }else if (data[mid] < data[j]){
                j = mid;
            }
        }
        return data[mid];
    }

    private static int minInOrder(int[] data, int i, int j) {
        int tem = data[i];
        for (int k = i; k <= j; k++) {
            if (data[k] < tem){
                tem = data[k];
            }
        }
        return tem;
    }
}
