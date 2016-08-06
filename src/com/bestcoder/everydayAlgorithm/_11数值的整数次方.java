package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 当指数exponent为负数时，可以先对指数求绝对值，然后算出次方的结果再取倒数
 * 既然有求倒数，考虑对0求倒数怎么处理这种错误（返回值|全局代码|异常）
 * 0的0次方在数学上无意义，输出0还是1都可以
 *
 * 思路：1.负指数可能对0求倒数 设全局变量提示
 *     2.double比较函数
 *     3.负指数加负号 取倒数
 *     4.这步主要 求base的exponent次方 exp =0返回1，=1返回base，递归求exp>>1(一半)的次方
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

    private static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)){
            return true;
        }else {
            return false;
        }
    }
}
