package com.bestcoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chentao on 16-6-21.
 */
public class 偶数大翻转_乐视 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                //如果为偶数
                if (a % 2 == 0) {
                    //取二进制并翻转
                    a = reserveBinery(a);
                    list.add(i, a);
                } else {
                    list.add(i, a);
                }
            }
            String result = "";
            for (int b : list) {
                result += b + " ";
            }
            System.out.println(result.trim());
            list.clear();
        }
    }

    private static int reserveBinery(int a) {
        String evenNum = Integer.toBinaryString(a);
        char[] charArray = evenNum.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            if (charArray[j] == '1'){
                evenNum = evenNum.substring(j);
                break;
            }
        }
        charArray = evenNum.toCharArray();
        char[] reserveCharArray = new char[charArray.length];
        int k = 0;
        for (int i = charArray.length-1; i >= 0; i--) {
            reserveCharArray[k++] = charArray[i];
        }
        a = Integer.parseInt(String.valueOf(reserveCharArray),2);
        return a;
    }
}
