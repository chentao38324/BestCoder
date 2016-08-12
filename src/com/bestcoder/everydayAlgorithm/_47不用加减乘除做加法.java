package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-12.
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路：十进制加法分三步：比如5+17
 *      1.各位相加不进位 得 12 2.做进位 10 3.前两个结果相加12+10=22
 *      二进制同样适用
 *      1.用异或  2.按位与 左移一位  3.重复前两步步骤，直到不产生进位
 */
public class _47不用加减乘除做加法 {
    public static void main(String[] args){
        System.out.println(sum(-3,-5));
    }

    public static int sum(int a,int b){
        int sumWithNoCarry = a ^ b;
        int carry = (a & b)<<1;
        int result = 0;
        while (carry != 0){
            result = sumWithNoCarry ^ carry;
            carry = (sumWithNoCarry & carry) << 1;
            sumWithNoCarry = result;
        }
        return sumWithNoCarry;
    }
}
