package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class ShuJuJiaoHuanShuChu2016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> list = new ArrayList<>();
            int n = in.nextInt();
            if (n==0) System.out.print("");
            else {
                for (int i = 0;i<n;i++){
                    int tem = in.nextInt();
                    list.add(i,tem);
                }
                int result = list.get(0);
                for (int min : list) {
                    if (result>min) {
                        result = min;
                    }
                }
                list.set(list.indexOf(result),list.get(0));
                list.set(0,result);
                String str = "";
                for (int i : list) {
                    str += i+" ";
                }
                System.out.println(str.trim());
            }

        }

    }
}
