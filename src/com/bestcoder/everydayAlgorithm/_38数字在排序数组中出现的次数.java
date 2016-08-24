package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 题目：统计一个数字：在排序数组中出现的次数。
 *      例如输入排序数组｛ 1, 2, 3, 3, 3, 3, 4, 5｝和数字3 ，由于3 在这个数组中出现了4 次，因此输出4 。
 *
 * 思路：利用的二分查找的思想，分别找第一个k和最后一个k，找第一个k时，如果中间值 == k时，
 *      先判断这个数字是不是第一个k。如果位于中间数字的前面一个数字不是k,此时中间的数字刚好就是第一个k。
 *      如果中间数字的前面一个数字也是k，也就是说第一个k肯定在数组的前半段， 下一轮我们仍然需要在数组的前半段查找。
 *      最后一个k同理
 *      二分查找O(logn)
 */
public class _38数字在排序数组中出现的次数 {
    public static void main(String[] args){
        int[] data = {1,2,3,3,3,3,4,5};
        int k = 3;
        System.out.println(k+"出现的次数："+getNumberOfK(data,k));
    }

    public static int getNumberOfK(int[] data,int k){
        if (data == null || data.length <= 0)
            return -1;
        int len = data.length;
        int firstK = getFirstK(data,len,k,0,len-1);
        int lastK = getLastK(data,len,k,0,len-1);
        return lastK-firstK+1;
    }

    public static int getFirstK(int[] data,int length,int k,int start,int end){
        if (data == null || length <= 0 || start > end)
            return -1;
        int midIndex = (start + end) / 2;
        int midNumber = data[midIndex];
        if (midNumber == k){ //如果中间值 == k
            if ((midIndex > start && data[midIndex-1] != k) || midIndex == start){
                return midIndex;
            }else {
                end = midIndex - 1;
            }
        }else if (midNumber > k){
            end = midIndex - 1;
        }else {
            start = midIndex + 1;
        }
        return getFirstK(data,length,k,start,end);
    }

    public static int getLastK(int[] data,int length,int k,int start,int end){
        if (data == null || length <= 0 || start > end)
            return -1;
        int midIndex = (start+end)/2;
        int midNumber = data[midIndex];
        if (midNumber == k){
            if ((midIndex < length - 1 && data[midIndex+1] != k) || midIndex == length -1 ){
                return midIndex;
            }else {
                start = midIndex + 1;
            }
        }else if (midIndex < k){
            start = midIndex + 1;
        }else {
            end = midIndex - 1;
        }
        return getLastK(data,length,k,start,end);
    }
}
