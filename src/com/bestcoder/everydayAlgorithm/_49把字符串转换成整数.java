package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-12.
 *  题目不难 要考虑的多
 *  非法输入的的处理 全局变量
 *  一开始输入“” null 的处理
 *  +— 号的处理
 *
 *  思路：判断 第一位 是 + OR - OR 0-9 OR others  同时赋值 第一位从哪里遍历 0 or 1 是不是负数 minus
 *       核心代码 core  遍历str 如果是0-9 进行转换 此时加个flag（-1 和 1）
 *       用公式 num = num×10 + flag（str.charAt(index)-'0'）
 *       判断num是否溢出
 */
public class _49把字符串转换成整数 {
    private static boolean gInvalid = false;

    public static void main(String[] args){
        System.out.println("int最大值："+Integer.MAX_VALUE+" int最小值："+Integer.MIN_VALUE);
        System.out.println("0x7FFFFFFF:"+0x7FFFFFFF+" 0x80000000:"+0x80000000);
        System.out.println(strToInt("-124234")+"");
    }

    public static long strToInt(String str){
        gInvalid = true; //输入有效 置位
        if (str == null || str.length() < 1){
            gInvalid = false;
            return 0;
        }

        char firstBit = str.charAt(0); //字符串第一位是什么
        int index = 0; //从哪一位开始转换
        boolean minus = false; //是否为负数
        if (firstBit == '-'){
            index = 1;
            minus = true;
        }else if (firstBit == '+'){
            index = 1;
        }else if (isDigit(firstBit)){
            
        }else { //开头不是+-号和数字
            gInvalid = false;
            return 0;
        }
        return strToIntCore(str,index,minus);
    }

    private static long strToIntCore(String str, int index, boolean isMinus) {
        long num = 0;
        for (int i = index; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                int flag = isMinus ? -1 : 1; //负数每次×-1 整数 × 1
                num = num * 10 + flag * (str.charAt(i) - '0');
                //正数负数溢出
                if ((!isMinus && num > 0x7FFFFFFF) || (isMinus && num < 0x80000000)){
                    gInvalid = false;
                    return 0;
                }
            }else { //除了第一位 某一位不是数字
                gInvalid = false;
                return 0;
            }
        }
        return num;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
