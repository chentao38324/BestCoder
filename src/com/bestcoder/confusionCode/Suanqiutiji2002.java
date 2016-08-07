package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Suanqiutiji2002 {
    public static final double PI = 3.1415927;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double R = in.nextDouble();
            double result = Math.pow(R,3)*PI*4/3;
            System.out.printf("%.3f",result);
            System.out.println();
        }
    }
}
