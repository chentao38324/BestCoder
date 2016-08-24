package com.bestcoder.everydayAlgorithm;

import java.util.Arrays;

/**
 * Created by chentao on 16-8-11.
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。
 *      2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
 *
 * 思路：做3 件事情： 首先把数组排序，再统计数组中0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。
 *      如果空缺的总数小于或者等于0 的个数，那么这个数组就是连续的：反之则不连续。
 *      最后，我们还需要注意一点： 如果数组中的非0 数字重复出现，则该数组不是连续的。
 *      换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 */
public class _44扑克牌中的顺子 {
    public static void main(String[] args){
        // 模拟随机抽牌，大小王为0，A为1，J为11，Q为12，K为13，其实就是个数组，判断数组是否是顺序的

        // 测试1：正好填补
        int array_1[] = { 0, 0, 1, 4, 5 };
        System.out.println(isContinuous(array_1));
        // 测试2：不能填补
        int array_2[] = { 0, 1, 4, 5, 6 };
        System.out.println(isContinuous(array_2));
        // 测试3：有相同元素
        int array_3[] = { 0, 1, 3, 3, 4, };
        System.out.println(isContinuous(array_3));
    }

    public static boolean isContinuous(int[] numbers){
        if (numbers == null || numbers.length < 1){
            return false;
        }
        int len = numbers.length;
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        //统计0的个数
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i] == 0){   //这里少统计一次最后一位是不是0，其实不用，排序后0只有两个只可能在1,2位置
                numberOfZero++;
            }else if (numbers[i] == numbers[i+1]){
                return false;
            }else {
                numberOfGap += (numbers[i+1] - numbers[i] - 1);//空缺总数
            }
        }
        if (numberOfZero >= numberOfGap){
            return true;
        }
        return false;
    }
}
