package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-27.
 */
public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String data = in.next();
//            StringBuffer sb = new StringBuffer(data);
            int n = in.nextInt();
            for (int i = 0;i<n;i++) {
                int p = in.nextInt();
                int l = in.nextInt();
                String before = data.substring(0,p+l);
                String after = data.substring(p+l);
                if (p<=l&&l+p<=data.length()) {
                    String temp = data.substring(p, p + l);
                    String temp1 = overStr(temp);
//                    sb = new StringBuffer();
//                    sb.append(before).append(temp1).append(after);
                    data = before+temp1+after;
                }else {
                    return;
                }
            }
            System.out.println(data);
        }
    }

    private static String overStr(String str) {
        char[] singleStr = str.toCharArray();
        char[] answer = new char[singleStr.length];
        for (int i = 0;i<singleStr.length;i++) {
            answer[i] = singleStr[singleStr.length-1-i];
        }
        String answer1 = new String(answer);
        return answer1;
    }
}
