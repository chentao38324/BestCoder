package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 题目：一个整形数组中除了两个数字之外，其他数字都出现了两次，找出这两个只出现一次的数字
 *      要求时间复杂度O(n) 空间复杂度O(1)
 *
 * 思路：如果只有一个数字值出现一次，那么从头到尾依次异或数组中的每一个数字，最终结果就是那个数字
 *      先将数组从头到尾异或一遍，得到的数字就是那两个只出现一次的异或的结果，因为他俩肯定不同，所以结果肯定不为0，
 *      二进制中定有某一位为1，从右边找到第一个不为0的位，按照这一位是否为0将数组分成两个子数组
 *      注意，数组不能动态增删，此处可以直接用两个int变量num1，num2，每发现该分到某一组时直接将元素与其异或
 *
 */
public class _40数组中只出现一次的数字 {

    public static void main(String[] args){
        int[] data = {2,4,3,6,3,2,5,5};
        findNumsAppearOnce(data);
    }

    public static void findNumsAppearOnce(int[] data){
        if (data == null || data.length <= 0){
            return;
        }
        int num1 = 0; //异或到最后剩下的num1  num2元素
        int num2 = 0;
        int tem = 0;  //最后两个元素异或的结果
        for (int num : data){
            tem ^= num;
        }
        int indexBit = findFirstBitIs1(tem);
        for (int num : data){
            if (isBit1(num,indexBit)){
                num1 ^= num;
            }else {
                num2 ^= num;
            }
        }
        System.out.println("只出现一次的数字是："+num1+"、"+num2);
    }

    //从右边找到第一位不为0的位
    public static int findFirstBitIs1(int num){
        int indexBit = 0;
        while ((num & 1) == 0){
            num >>>= 1;
            indexBit++;
        }
        return indexBit;
    }
    //判断num从右边起第index位是否为1
    public static boolean isBit1(int num,int index){
        num >>>= index;
        return (num & 1) == 1;
    }
}
