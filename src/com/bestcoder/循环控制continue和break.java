package com.bestcoder;

/**
 * Created by chentao on 16-5-26.
 */
public class 循环控制continue和break {
    public static void main(String[] args){
        outer:for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j > i) {
                    System.out.println();
//                    break;
                    continue outer;
                }
                System.out.print(j+"x"+i+"="+j*i+" ");
            }
        }
    }
}
