package com.bestcoder;

/**
 * Created by chentao on 16-6-6.
 */
import java.util.Scanner;
public class 魔方 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            for (int i = 0; i < a; i++) {

            }
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
