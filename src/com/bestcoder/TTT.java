package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-3.
 */
public class TTT {
    public static void main(String[] args) {
        System.out.println("请输入一个整数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        int value = 1;
        int x = 0;
        int y = n - 1;
//        a[0][n - 1] = 1;
//        a[1][n - 1] = 2;
//        a[2][n - 1] = 3;
//        a[3][n - 1] = 4;
//        a[3][n - 2] = 5;
//        a[3][n - 3] = 6;
//        a[3][n - 4] = 7;
//        a[2][n - 4] = 8;
//        a[1][n - 4] = 9;
//        a[0][n - 4] = 10;

        for (int t = 0; t < n; t++) {
            for (int k = 0; k < n; k++) {
                a[t][k] = 0;
            }
        }

        while (value < n * n) {
            while (x + 1 < n && a[x + 1][y] == 0) {
                a[x][y] = value;
                x++;

                value++;
            }
            while (y > 0 && a[x][y - 1] == 0) {
                a[x][y] = value;
                y--;

                value++;
            }
            while (x > 0 && a[x - 1][y] == 0) {
                a[x][y] = value;
                x--;
                value++;
            }
            while (y + 1 < n && a[x][y + 1] == 0) {
                a[x][y] = value;
                y++;
                value++;
            }
        }

        for (int l = 0; l < n; l++) {
            for (int c = 0; c < n; c++) {
                if (c != n - 1) {
                    System.out.print(a[l][c] + "   ");

                } else {
                    System.out.println(a[l][c]);
                }
            }
        }

    }
}
