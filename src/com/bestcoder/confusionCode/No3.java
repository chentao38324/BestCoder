package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-27.
 */
public class No3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int s = in.nextInt();
            int L = in.nextInt();
            int x = 0;//每个专辑方几首歌
            int y = 0;//cd数
            x = (L+1)/(s+1);
            if (x % 13 == 0) {
                x +=1;
            }
            y = n/x;
            if (n%x != 0) {
                y += 1;
            }
            System.out.println(y);
        }


    }
}
