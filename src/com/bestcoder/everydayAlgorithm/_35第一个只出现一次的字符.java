package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-10.
 *
 * 思路：用一个辅助数组（大小256所有的ASKII码） 数组大小是个常数 所以空间复杂度为O（1）
 *      第一次遍历 字符串中的每一个char字符对应的辅助数组中的位置++，时间O（n）
 *      注意：第二次遍历 如果遍历 辅助数组 会返回编码在前的字符 错误 ，所以要遍历 输入的字符串
 *
 * 相关题目：
 * 1.输入两个字符串，从第一个字符串中删除在第二个字符串中出现过的字符
 *      思路：用上题的简单哈希存储第二个字符串，这样遍历第一个字符串的时候 能用O（1）时间判断该不该删除
 * 2.删除字符串中所有重复出现的字符 “google” -->“gole”
 */
public class _35第一个只出现一次的字符 {
    public static void main(String[] args){
        String str = "goog";
        char result = firstNotReprtingChar(str);
        System.out.println(result);
        //相关题目3
        deleteRepeatingChar("google");
    }

    public static char firstNotReprtingChar(String str){
        if (str == null || str.equals(""))
            return '0';
        char result = '0';
        char[] array = str.toCharArray();
        int[] times = new int[256]; //辅助数组
        for (char item : array){
            times[(int)item]++;
        }
        for (int i = 0; i < array.length;i++){ //这里要遍历输入的字符串 才能输出第一次出现一次的字符
            if (times[array[i]] == 1) {
                result = array[i];
                break;
            }

        }
        return result;
    }

    //实现相关题目2
    public static void deleteRepeatingChar(String str){
        if (str == null || str.length() < 1)
            return;
        char[] array = str.toCharArray();
        boolean[] isDelete = new boolean[256];
        for (int i = 0;i < array.length;i++){
            if (!isDelete[array[i]]) {
                System.out.print(array[i]);
                isDelete[array[i]] = true;
            }
        }
    }
}
