package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-1.
 */
public class 统计难题1251 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list_words = new ArrayList<>();
        int i = 0;//单词个数
        //收集单词
        while (in.hasNext()) {
            String word = in.nextLine();
            if (!"".equals(word)) {
                list_words.add(i++, word);
            }else break;
        }
        //接收前缀输入提问
        while (in.hasNext()) {
            int num = 0;
            String pre_word = in.nextLine();
            //判断前缀和哪些单词匹配
            if (!"".equals(pre_word)) {
                int pre_word_num = pre_word.length();
                for (String str : list_words) {
                    if ((str.length() >= pre_word_num)) {
                        if (pre_word.equals(str.substring(0, pre_word_num))) {
                            num++;
                        }
                    }
                }
                System.out.println(num);
            }
        }


    }
}
