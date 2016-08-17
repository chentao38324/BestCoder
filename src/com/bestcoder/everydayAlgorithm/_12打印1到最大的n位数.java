package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 题目：输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3 打印1,2,3一直到999
 */
public class _12打印1到最大的n位数 {
    public static void main(String[] args){
        print1ToMaxOfNDigits(6);
    }

    //方法一：全排序实现-递归
    public static void print1ToMaxOfNDigits(int n){
        if (n<=0)  return;
        int[] number = new int[n];
        for (int i = 0; i < 10; i++) {
            number[0] = i;
            print1ToMaxOfNDigitsRecursively(number,n,0);
        }
    }

    private static void print1ToMaxOfNDigitsRecursively(int[] number, int length, int index) {
        if (index == length-1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1] = i;
            print1ToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }

    //把数组表达的数字打印出来  从第一个非0数字开始打印 eg. 0980  打印 980
    private static void printNumber(int[] number) {
        boolean isBeginning0 = true;

        for (int i = 0; i < number.length; i++) {
            if (isBeginning0 && number[i] != 0){
                isBeginning0 = false;
            }
            if (!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    //方法二： 我们要知道什么时候停止在number上+1.即什么时候到了最大的n位数99999...  代码较长 面试写出来不实际
    // 这里需要一个小技巧，我们只需判断最高位（第n位）是否要进位，如果需进位，则已经为最大数  返回true
    public static void print1ToMaxOfNDigit(int n){
        if (n<=0) return;
        int[] number = new int[n];
        while (!increment(number)){ //在数组表达的数字上模拟加法
            printNumber(number);    //把数组表达的数字打印出来
        }
    }

    //在数组表达的数字上模拟加法
    //有点看不懂啊
    private static boolean increment(int[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            int nSum = number[i] + nTakeOver;
            if (i == number.length - 1) nSum++;
            if (nSum >= 10){
                if (i == 0) isOverflow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = nSum;
                }
            }else {
                number[i] = nSum;
                break;
            }
        }
        return isOverflow;
    }
}
