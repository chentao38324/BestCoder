package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-19.
 */
public class tt2 {
    public static void main(String[] args) {
        tt2 x = new tt2();
        int[][] n = {{1, 1, 1, 1}, {0, 0, 0, 0}, {1, 0, 1, 1}};
        for (int i : x.getPartition(n, 4, 3)) {
            System.out.println(i);
        }

//        x.getPartition();
    }
    public int[] getPartition(int[][] land, int n, int m) {
        // write code here
        int Good = 0;
        int[] AArray = new int[n];
        int[] BArray = new int[n];


        for (int i = 0; i < n; i++) {
            int temp_0 = 0;
            int temp_1 = 0;
            for (int j = 0; j < m; j++) {
                if (land[j][i] == 0) {
                    temp_0++;
                } else {
                    temp_1++;
                }
            }
            AArray[i] = temp_0;
            BArray[i] = temp_1;
        }
        int tShu;
        int Fenjie;
        for (int i = 0; i < n; i++) {
            Good += AArray[i];
        }


        tShu = Good;
        Fenjie = 0;
        for (int i = 1; i < n; i++) {


            Good = 0;
            for (int j = i; j < n; j++) {
                Good += AArray[j];
            }
            for (int j = 0; j < i; j++) {
                Good += BArray[j];
            }
            if (Good < tShu) {
                Fenjie = i;
                tShu = Good;
            }
        }
        Good = 0;
        for (int i = 0; i < n; i++) {
            Good += AArray[i];
        }
        if (Good < tShu) {
            Fenjie = n;
        }

        int[] OK = {Fenjie, Fenjie + 1};
        return OK;
    }
}
