package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Qiujueduizhi2003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double count = in.nextDouble();
            double result = Math.abs(count);
            System.out.printf("%.2f",result);
            System.out.println();
        }

    }
}
