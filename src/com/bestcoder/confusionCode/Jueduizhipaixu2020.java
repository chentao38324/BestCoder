package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Jueduizhipaixu2020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> metia_list = new ArrayList<>();
            List<Integer> abs_list = new ArrayList<>();
            int n = in.nextInt();
            if (n == 0) System.out.print("");
            else {
                for (int i = 0;i<n;i++) {
                    int count_metia = in.nextInt();
                    metia_list.add(i,count_metia);
                }
                int tem = 0;
                for (int i =0;i<n;i++) {
                    for (int j = i;j<n;j++) {
                        if (Math.abs(metia_list.get(i))<Math.abs(metia_list.get(j))) {
                            tem = metia_list.get(i);
                            metia_list.set(i,metia_list.get(j));
                            metia_list.set(j,tem);
                        }
                    }
                }
                String str = "";
                for (int i : metia_list) {
                    str += i+" ";
                }
                System.out.println(str.trim());
            }

        }

    }
}
