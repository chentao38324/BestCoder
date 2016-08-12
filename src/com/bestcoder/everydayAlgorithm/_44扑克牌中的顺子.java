package com.bestcoder.everydayAlgorithm;

import java.util.Arrays;

/**
 * Created by chentao on 16-8-11.
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
                numberOfGap += (numbers[i+1] - numbers[i] - 1);
            }
        }
        if (numberOfZero >= numberOfGap){
            return true;
        }
        return false;
    }
}
