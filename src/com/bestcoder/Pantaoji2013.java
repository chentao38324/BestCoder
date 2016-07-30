package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Pantaoji2013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int result = 1;
            int n = in.nextInt();
            for (int i = 1;i<n;i++) {
                result = result*2+2;
            }
            System.out.println(result);
        }

    }
}
