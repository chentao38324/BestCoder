package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Muniu2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> list = new ArrayList<>();
            int n = in.nextInt();
            if (n == 0) {
                System.out.print("");
            } else if (n >= 1 & n <= 3) {
                System.out.println(n);
            } else if (n > 3) {

                list.add(0, 1);
                list.add(1, 2);
                list.add(2, 3);
                for (int i = 3; i < n; i++) {
                    list.add(i, list.get(i - 1) + list.get(i - 3));
                }
                System.out.println(list.get(n - 2) + list.get(n - 4));
            }

        }

    }

}