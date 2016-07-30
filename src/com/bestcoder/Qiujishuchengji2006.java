package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Qiujishuchengji2006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int tem = 1;
            int num = in.nextInt();
            for (int i = 1;i<=num;i++) {
                int count = in.nextInt();
                if (count%2 != 0) {
                    //奇数
                    tem *= count;
                }
            }
            System.out.println(tem);
        }

    }
}
