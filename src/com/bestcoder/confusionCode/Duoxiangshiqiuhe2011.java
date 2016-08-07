package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Duoxiangshiqiuhe2011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        while (in.hasNext()) {
            int m = in.nextInt();
            for (int i =0;i<m;i++) {
                int n = in.nextInt();
                list.add(i,getNNum(n));
            }
            for (double result : list) {
                System.out.printf("%.2f",result);
                System.out.println();
            }
        }

    }
    //求前n项和
    private static double getNNum(int n) {
        double tem = 0;
        for (int i =1;i<=n;i++) {
            if (i%2 == 0) {
                tem -= 1d/i;
            }else tem += 1d/i;
        }
        return tem;
    }
}
