package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-31.
 2
 3
 1 2 3
 4
 4 3 2 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> list = new ArrayList<>();
            List<int[]> list_int = new ArrayList<>();
            int groupNum = in.nextInt();
            for (int i = 0;i<groupNum;i++) {
                int groupINum = in.nextInt();
                int[] groupI = new int[groupINum];
                for (int j = 0; j < groupINum; j++) {
                    groupI[j] = in.nextInt();
                }
                list_int.add(i,groupI);
            }

//            int groupTwoNum = in.nextInt();
//            int[] groupTwo = new int[groupTwoNum];
//            for (int i =0;i<groupTwoNum;i++) {
//                groupTwo[i] = in.nextInt();
//            }
            //得到了两个数组了，开始排序
            for (int i= 0;i<groupNum;i++) {
                int one = spicialSort(list_int.get(i));
                list.add(i,one);
            }
            for (int i =0 ;i<groupNum;i++) {
                System.out.println(list.get(i));
            }

        }

    }

    private static int spicialSort(int[] groupOne) {
        int len = groupOne.length;
        int times = 0;
//        for (int i = 0;i<len;i++) {
//            for (int j= 0;j<len-i;j++) {
//                if (groupOne[i]>groupOne[j]) {
//                    swap(groupOne[i],groupOne[j]);
//                    times += 1;
//                    System.out.println(times);
//                }
//            }
//        }
//        int tt = (len-1)*(len-2);
        for (int j = 0;j<len-1;j++) {
            for (int k = 0;k<len-1;k++) {
//                System.out.println(len);

                if (groupOne[k] > groupOne[k + 1]) {
                    int temp = groupOne[k];
                    groupOne[k] = groupOne[k + 1];
                    groupOne[k + 1] =temp;
//                    swap(groupOne[k], groupOne[k + 1]);
//                    System.out.println(groupOne[k]);

                    times += 1;
//                    System.out.println(times);
                }
            }
        }
        return times;
    }

    private static void swap(int m, int n) {
        int tem = 0;
        tem = m;
        m = n;
        n = tem;
    }
}
