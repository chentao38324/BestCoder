package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Sushupanduan2012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int x =in.nextInt();
            int y = in.nextInt();
            if (x>y){
                int tem = x;
                x = y;
                y = tem;
            }
            if (x==0&y==0) {
                System.out.print("");
            }else {
                boolean temp = true;
                for (int i = x;i<y+1;i++) {
                    int result = i*i+i+41;
                    if (isSushu(result)) {
                        temp &= true;
                    }else temp &= false;
                }
                if (temp) System.out.println("OK");
                else System.out.println("Sorry");
            }
        }

    }

    private static boolean isSushu(int result) {
        boolean tem = true;
        for (int i = 2;i<result;i++) {
            if (result%i != 0) tem &= true;
            else tem &=false;
        }
        return tem;
    }
}
