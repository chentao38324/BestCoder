package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-20.
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 */
public class 一站通offer一 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String data = in.nextLine();
            int len = in.nextInt();
            System.out.println(trans(data,len));
        }
    }

    private static String trans(String data, int len) {
        String result = "";
        String temp = "";

        for (int i =0;i<len;i++) {
            char one = data.charAt(i);
            if (one>=97) {
                one -= 32;
                temp += one+"";
            }else if (one>=65){
                one += 32;
                temp += one+"";
            }else if (one == 32) {
                result = " "+temp+result;
                temp = "";
            }
        }
        result = temp + result;
        return result;
    }
}
