package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-27.
 */
public class No5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int x = in.nextInt();
            int k = in.nextInt();
            int k1 = 0;
            int y = 1;
            while (y>0) {
                if ( (x|y) == (x+y)) {
                    k1++;
                    if (k1 == k) {
                        System.out.println(y);
                    }
                }
                y++;
            }
        }


    }
}
