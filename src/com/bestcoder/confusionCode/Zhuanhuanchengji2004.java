package com.bestcoder.confusionCode;

import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 */
public class Zhuanhuanchengji2004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int score = in.nextInt();
            if (score>=0&&score<=100) {
                if (score>=0&&score<=59) {
                    System.out.println("E");
                }else if (score>=60&&score<=69){
                    System.out.println("D");
                }else if (score>=70&&score<=79){
                    System.out.println("C");
                }else if (score>=80&&score<=89){
                    System.out.println("B");
                }else {
                    System.out.println("A");
                }
            }else {
                System.out.println("Score is error!");
            }
        }
    }

}
