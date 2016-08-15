package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-13.
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *
 * 思路： 用一个哈希表实现，用字符的ASCII码作为键值 字符对应的位置
 *
 *      感觉这题和35 没啥区别 为啥要用这种方法 还复杂了？ 都是时间复杂度O(n) 啊？？？
 */
public class _55字符流中第一个不重复的字符 {    // 出现一次的标识
    private int index = 0;
    private int[] occurrence = new int[256];

    public _55字符流中第一个不重复的字符() {
        for (int i = 0; i < occurrence.length; i++) {
            occurrence[i] = -1;
        }
    }

    private void insert(char ch) {
        if (ch > 255) {
            throw new IllegalArgumentException( ch + "must be a ASCII char");
        }

        // 只出现一次
        if (occurrence[ch] == -1) {
            occurrence[ch] = index;
        } else {
            // 出现了两次
            occurrence[ch] = -2;
        }

        index++;
    }

    public char firstAppearingOnce(String data) {
        if (data == null) {
            throw new IllegalArgumentException(data);
        }

        for (int i = 0; i < data.length(); i++) {
            insert(data.charAt(i));
        }
        char ch = '\0';
        // 用于记录最小的索引，对应的就是第一个不重复的数字
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < occurrence.length; i++) {
            if (occurrence[i] >= 0 && occurrence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrence[i];
            }
        }

        return ch;
    }

    public static void main(String[] args) {
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("")); // '\0'
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("g")); // 'g'
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("go")); // 'g'
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("goo")); // 'g'
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("goog")); // '\0'
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("googl")); // l
        System.out.println(new _55字符流中第一个不重复的字符().firstAppearingOnce("google")); // l
    }

}
