package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 * 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。
 */
public class Pinfangyulifanghe2007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (m>n){
                int tem = m;
                m = n;
                n = tem;
            }
            int sum_even = 0;
            int sum_odd = 0;
            for (int i =m;i<=n;i++) {
                if (i%2 == 0) {
                    sum_even += i*i;
                }else {
                    //奇数
                    sum_odd += i*i*i;
                }
            }
            System.out.println(sum_even+" "+sum_odd);
        }

    }
}
