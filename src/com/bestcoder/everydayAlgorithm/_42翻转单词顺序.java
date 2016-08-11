package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 题目：输入一个英文句子翻转句子中单词的顺序，但单词内字符顺序不变，标点和字母统一处理
 *      例："I am a student." -->"student. a am I"
 *
 * 思路：两次翻转字符串法，第一步翻转句子中所有的字符串，第二步，翻转每个单词中字符的顺序
 *      主要实现翻转字符串函数reverse，第二步判断要翻转的地方
 */
public class _42翻转单词顺序 {

    public static void main(String[] args){
        String str = "I am a student.";
        System.out.println(reverseSentence(str));
    }

    public static String reverseSentence(String data){
        if (data == null || data.length() < 1){
            return "WRONG INPUT！";
        }
        char[] c = data.toCharArray();
        int start = 0;
        int end = 0;
        int lengthOfTerm = 0;
        //所有数组翻转
        reverse(c,0,c.length-1);
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' '){
                end = i - 1;
                start = end - lengthOfTerm + 1;
                reverse(c,start,end);
                lengthOfTerm = 0;
            }else {
                lengthOfTerm++;
            }
        }
        return new String(c);
    }

    /**
     * 对每个字符数组翻转
     * @param c 要翻转的字符数组
     * @param start 字符串起始
     * @param end 结束
     */
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
