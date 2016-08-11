package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 题目:上题延伸， 左旋转 比如"abcdefg" 2位-->"cdefgab"
 × 思路：先将0到index-1和index到end-1 reverse ,再全部reverse
 */
public class _42_1字符串的左旋转操作 {
    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(leftRotateString(str,2));
    }

    public static String leftRotateString(String str,int index){
        if (str == null || str.length() < 0 || index < 0 || index >str.length())
            return "Wrong input";
        if (index ==0 || index == str.length())
            return str;
        int len = str.length();
        char[] dataCharArray = str.toCharArray();
        reverse(dataCharArray,0,index-1);
        reverse(dataCharArray,index,len-1);
        reverse(dataCharArray,0,len-1);
        return new String(dataCharArray);
    }

    public static void reverse(char[] c,int start,int end){
        if (c == null || start >= end)
            return;
        while (start < end){
            char tem = c[start];
            c[start] = c[end];
            c[end] = tem;
            start++;
            end--;
        }
    }
}
