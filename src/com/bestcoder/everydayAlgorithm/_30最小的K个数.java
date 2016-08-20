package com.bestcoder.everydayAlgorithm;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by chentao on 16-8-9.
 * 题目：输入n个数的数组，输出其中最小的k个数
 *
 * 解法一：O(n) 可以修改输入的数组时可用
 *      用快排的思想
 *
 * 解法二：O(nlogk)使用TreeSet（基于红黑树的思路） 特别适合海量数据的输入
 *      在TreeSet中存储最小的k个数，遍历数组，如果容器没满，直接把这次读入的数插入，
 *      满了就替换已有的最大数
 *
 *      因此当容器满了之后，我们要做3 件事情： 一是在k 个整数中找到最大数：
 *      二是有可能在这个容器中删除最大数： 三是有可能要插入一个新的数字。
 *      使用TreeSet（基于红黑树的思路）可以实现
 */
public class _30最小的K个数 {
    public static void main(String[] args){
        int[] array = {4,5,1,6,2,7,3,8};
        getLeastNumbers(array,4);//解法一

        TreeSet<Integer> set = getLeastNumbers1(array,4);
        Iterator<Integer> it = set.iterator();
        System.out.println("\n方法二,用TreeSet实现:");
        while (it.hasNext()){
            int n = it.next();
            System.out.print(n+" ");
        }
    }

    //解法一 O(n) 可以修改输入的数组时可用
    public static void getLeastNumbers(int[] input,int k){
        if (input == null || input.length == 0 || k > input.length)
            return;

        int left = 0;
        int right = input.length - 1;
        int index = partition(input,left,right);
        while (index != k-1){
            if (index > k-1){
                index = partition(input,left,index-1);
            }else {
                index = partition(input,index+1,right);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(input[i]+" ");
        }
    }

    private static int partition(int[] input, int left, int right) {
        int tem;
        int result = 0;
        int l ;
        int r ;
        if (left < right){
            l = left + 1;
            r = right;
            while (true){
                for (int i = l; i < r; i++) {
                    if (input[i] > input[left]){
                        l = i;
                        break;
                    }
                    l++;
                }
                for (int i = r; i >= l; i--) {
                    if (input[i] < input[left]){
                        r = i;
                        break;
                    }
                    r--;
                }
                if (l<r){
                    tem = input[l];
                    input[l] = input[r];
                    input[r] = tem;
                }else {
                    break;
                }
            }
            if (l>=r){
                tem = input[left];
                input[left] = input[r];
                input[r] = tem;
                result = r;
            }
        }
        return result;
    }

    //解法二
    public static TreeSet<Integer> getLeastNumbers1(int[] array,int k){
        if (array == null || array.length == 0 || k <= 0 || k>= array.length)
            return null;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.size() < k){    // 如果TreeSet中的元素小于K个，则直接插入
                set.add(array[i]);
            }else { // TreeSet中的元素大于K个
                if (array[i] < set.last()){ //array[i]<最大的元素
                    set.pollLast(); //移除
                    set.add(array[i]);  //加入新的
                }
            }
        }
        return set;
    }
}
