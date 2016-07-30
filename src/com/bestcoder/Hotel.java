package com.bestcoder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-5.
 */
public class Hotel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        int[] aa = new int[]{1,1,1,2,2,2,3,3,4,2,1,1,2};
        Arrays.sort(aa);

        for (int i = 0;i<aa.length;i++) {
            System.out.println(aa[i]);

        }
//        while (in.hasNext()) {
            int M = 3;
            int[] a ={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};

            int temp=0;
            for(int i=0;i<a.length-1;i++){
                for(int j=0;j<a.length-1-i;j++){
                    if(a[j]>a[j+1]){
                        temp=a[j];
                        a[j]=a[j+1];
                        a[j+1]=temp;
                    }
                }
            }
            for(int i=0;i<M;i++)
                System.out.println(a[i]);
//        }
    }
}
