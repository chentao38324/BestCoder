package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 题目1：输入一个递增排序的数组和一个数字s，数组中找两个数，使得它们和为s，若有多对，输出任意一对即可
 *       例如输入数组｛1 、2 、4、7 、11 、15 ｝和数字15. 由于4+ 11 = 15 ，因此输出4 和11 。
 *
 * 思路：O(n)如果选择了两个数字，它们和==s，就找到了，如果小于s，因为数组已经排好序就选择较小数字的后面数字;
 *      大于s，就选较大数字前面的数字。用两个指针从两端像中间移动
 *
 * 题目2：输入一个正整数s，打印所有和为s的连续正数序列（至少含两个数）
 *
 * 思路：用两个数表示序列的最小值和最大值small和big，small初始化为1，big初始化为2
 *      如果从small到big的序列和大于s，从序列中去掉较小的值，增大small，让序列包含更少的数字
 *      如果从small到big的序列和小于s，增大big，让序列包含更多的数字
 *      因为最少要两个数字，所以small增加到（1+s）/2为止 1到s中间的数字
 */
public class _41和为S的两个数字VS和为S的连续正数序列 {
    public static void main(String[] args){
        int[] data = {1,2,4,7,11,15};
        int sum = 15;
        findNumbersWithSum(data,sum);
        findContinuousSequence(5);
    }

    //题目1
    public static void findNumbersWithSum(int[] data,int sum){
        if (data == null || data.length <= 0)
            return;
        int len = data.length;
        int i = 0;
        int j = len - 1;
        while (i <= j){
            int curSum = data[i] + data[j];
            if (curSum == sum){
                System.out.println("和为"+sum+"的两个数字是"+data[i]+"和"+data[j]);
                break;
            }else if (curSum < sum){
                i++;
            }else {
                j--;
            }
        }
    }

    //题目2
    public static void findContinuousSequence(int sum){
        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (1 + sum)/2;
        int curSum = small + big;
        while (small < middle){
            if (curSum == sum){     //如果输入4  没答案，可以定义个boolean ==时设为true 最后判断 false 输出没有
                printCountinuousSequence(small,big);
                big++;
                curSum += big;
            }else if (curSum > sum){
                curSum -= small;
                small++;
            }else {
                big++;
                curSum += big;
            }
        }
    }

    private static void printCountinuousSequence(int small, int big) {
        for (int i = small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
