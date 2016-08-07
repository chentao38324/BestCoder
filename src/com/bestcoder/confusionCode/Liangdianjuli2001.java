package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Liangdianjuli2001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double result1 = Math.pow(x2-x1,2)+Math.pow(y2-y1,2);
            double result = Math.sqrt(result1);
            System.out.printf("%.2f",result);
            System.out.println();
        }
    }
}
