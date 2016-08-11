package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-9.
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，找出这个数字。
 *
 * 思路： O（n）
 * 在遍历数组的过程中纪录两个量，一个是数组中的数字，一个是次数，当下一个数字和我们保存的一致时则次数加1，
 * 当不一致时次数减1，当次数为0时，重置两个量。数组中的数字为当前访问的值，次数为1。
 * 这里主要是利用了出现的次数超过了一半，其实就是超过一半数出现的次数减去其他的数出现的次数始终是大于0的。
 *
 * 也可以用快排的思路 排序后 直到 参考元素的索引为数组长度的一半 下一题有使用
 */
public class _29数组中出现次数超过数组长度一半的数字 {
    public static void main(String[] args){
        int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        System.out.println(moreThanHalfNum(array));
    }

    public static int moreThanHalfNum(int[] numbers){
        if (numbers == null || numbers.length == 0)
            return 0;
        int len = numbers.length;
        int times = 1;
        int result = numbers[0];
        for (int i = 1; i < len; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanhalf(numbers,len,result))
            result = 0;
        return result;
    }

    private static boolean checkMoreThanhalf(int[] numbers, int len, int result) {
        int times = 0;
        for (int i = 0; i <len ; i++) {
            if (numbers[i] == result)
                times++;
        }
        boolean isMoreThanHalf = true;
        if (times*2<=len)
            isMoreThanHalf = false;
        return isMoreThanHalf;
    }
}
