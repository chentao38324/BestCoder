package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 题目：实现函数 double power(double base,int exponent) 求base的exponent次方，不用库函数 考虑大数
 *
 * 当指数exponent为负数时，可以先对指数求绝对值，然后算出次方的结果再取倒数
 * 既然有求倒数，考虑对0求倒数怎么处理这种错误（返回值|全局代码|异常）
 * 0的0次方在数学上无意义，输出0还是1都可以
 *
 * 思路：1.负指数可能对0求倒数 设全局变量提示
 *      2.double比较函数
 *      3.负指数加负号 取倒数
 *      4.这步主要 求base的exponent次方 exp =0返回1，=1返回base，递归求exp>>1(一半)的次方
 *     之后判断如果奇数（和1与 ==1） 再×base
 */
public class _11数值的整数次方 {
    public static boolean gInvalid = false;
    public static void main(String[] args){
        double result = power(2,10);
        System.out.println("结果："+result);
    }

    public static double power(double base,int exponent){
        gInvalid = false;
        if (equal(base,0.0) && exponent < 0){
            gInvalid = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0){
            absExponent = -exponent;
        }
        double result = powerWithUnsignedExponent(base,absExponent);
        if (exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 改进后的核心方法
     * 原来只要i<指数 就乘 做指数-1次乘法，
     * 比如求32次方，如果已知16次方，只要在16次方的基础上在平方一次就行，而16次方又是8次方的平方
     * 这样下来求32次方只要做5次乘法 log32 = 5
     * 有这样一个公式（乘方的性质）
     *          |（a的n/2次方）×（a的n/2次方）   n为偶数
     * a的n次方 =
     *          |（a的n-1/2次方）×（a的n-1/2次方）×a
     * 这个公式很容易用递归实现
     * @param base
     * @param exponent
     * @return
     */
    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent == 1) return base;
        double result = powerWithUnsignedExponent(base,exponent>>1);
        result *= result;
        if ((exponent & 0x1) == 1){ //指数是奇数
            result *= base;
        }
        return result;
    }

    //float、double两种基本类型在运算的时候容易引起精度丢失
    //解决办法:利用java.math中的BigDecimal类进行操作
    //但是java中比较两个数大小好像没有问题，有的话 应该比较两个数的差是不是在一个很小的范围
    private static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)){
            return true;
        }else {
            return false;
        }
    }
}
