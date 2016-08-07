package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Zhaofushuzhengshugeshu2008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int positiveNumberNum = 0;
        int negativeNumberNum = 0;
        int zeroNumberNum = 0;
        double count;
        while (in.hasNext()) {
            int countNum = in.nextInt();
            if (countNum != 0) {
                for (int i =0;i<countNum;i++) {
                    count = in.nextDouble();
                    if (count < 0){
                        negativeNumberNum += 1;
                    }else if (count > 0){
                        positiveNumberNum += 1;
                    }else if (count == 0){
                        zeroNumberNum += 1;
                    }
                }
                System.out.println(negativeNumberNum+" "+zeroNumberNum+" "+positiveNumberNum);
                negativeNumberNum =0;
                positiveNumberNum = 0;
                zeroNumberNum = 0;
            }else {
                System.out.print("");
            }
        }

    }
}
