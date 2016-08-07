package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 * 可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，
 * 如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
 */
public class _14调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,4,4,5,6};
        preOrderOddEven(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static void preOrderOddEven(int[] data){
        if (data.length == 0 || data == null) return;
        int tem;
        int left = 0;
        int right = data.length - 1;
        while (left < right){
            while (left<right && !isEven(data[left]))//如果是奇数 指针后移
                left++;
            while (left<right && isEven(data[right]))//如果是偶数 指针前移
                right--;
            if (left < right){
                tem = data[left];
                data[left] = data[right];
                data[right] = tem;
            }
        }
    }

    //这里是解耦，评判数组中的数改在前半部分还是后半部分，这个标准改动后 只需该这个函数即可
    public static boolean isEven(int number){
        return (number & 1) == 0;
    }
}
