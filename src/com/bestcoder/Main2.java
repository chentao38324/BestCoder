package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String inputStr = in.nextLine();
            int len = in.nextInt();

            System.out.println(test(inputStr,len));
        }


    }

    private static String test(String s, int n) {
        String[] result = new String[s.split(" ").length];
        String tep = "";
        for (int i = 0,j=s.split(" ").length-1;i<n;i++) {
            char item = s.charAt(i);
            if (item != 32) {//不是空格
                if (item>=97&&item<=122) {//小写
                    item -= 32;
                    tep += item+"";
                }else if (item>=65&&item<=90){//大写
                    item += 32;
                    tep += item+"";
                }
            }else {
                result[j--] = tep+" ";
                tep = "";
            }
            if (i == n-1) {
                result[0] = tep+" ";
            }

        }
        String re = "";
        for (int i = 0 ;i <result.length;i++) {
            re = re+result[i];
        }
        return re.trim();
    }
}
