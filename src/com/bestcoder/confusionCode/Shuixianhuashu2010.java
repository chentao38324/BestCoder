package com.bestcoder.confusionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Shuixianhuashu2010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> nums = new ArrayList<>();
            int j = 0;
            String ok = "";
            int m = in.nextInt();
            int n = in.nextInt();
            for (int i =m;i<=n;i++) {
                if (isSXH(i)){
                    //是水仙花数
                    nums.add(j++,i);
                }
            }
            if (j != 0) {
                for (int item : nums) {
                    ok+=item+" ";
                }
                System.out.println(ok.trim());
            }else {
                System.out.println("no");
            }
        }


    }

    private static boolean isSXH(int i) {
        int x1 = i/100%10;
        int x2 = i/10%10;
        int x3 = i%10;
        int result = (int)(Math.pow(x1,3)+Math.pow(x2,3)+Math.pow(x3,3));
        if (i == result) {
            return true;
        }
        return false;
    }
}
