package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-12.
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 时间复杂度是O(n)  每个数字最多交换两次就能找到属于他自己的位置
 * 空间复杂度为O(1)
 * 思路：依然从头到尾一次扫描这个数组中的每个数字。当扫描到下标为i的数字时，首先比较这个数字（用m表示）是不是等于i。
 * 如果是，接着扫描下一个数字。如果不是，再拿它和第m个数字进行比较。如果它和第m个数字相等，
 * 就找到了一个重复的数字（该数字在下标为i和m的位置都出现了）。如果它和第m个数字不相等，
 * 就把第i个数字和第m个数字交换，把m放到属于它的位置。接下来再重读这个比较、交换的过程，直到我们发现一个重复的数字。
 */
public class _51数组中重复的数字 {

    public static void main(String[] args){
        int[] array = {2,1,1,0,2,5,3};
        System.out.println(duplicate(array));
    }

    public static int duplicate(int[] data){
        if (data == null || data.length < 1){
            return -1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0 || data[i] > data.length-1){
                return -1;
            }
        }
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int m = data[i];
            if (m != i) {
                if (m == data[m]) {
                    return m;
                } else { //m 去了它该去的索引位置
                    int tem = data[i];
                    data[i] = data[m];
                    data[m] = tem;
                }
            }
        }
        return -1;
    }
}
