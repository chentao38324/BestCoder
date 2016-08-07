package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Shuliehe2009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double tem = 0;
            int n = in.nextInt();
            int m = in.nextInt();
                for (int i =0;i<m;i++) {
                    tem += Math.pow(n,1.0/Math.pow(2,i));
            }
            System.out.printf("%.2f",tem);
            System.out.println();
        }

    }
}
