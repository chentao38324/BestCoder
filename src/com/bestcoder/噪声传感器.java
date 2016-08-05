package com.bestcoder;

/**
 * Created by chentao on 16-6-6.
 */
import java.util.Scanner;
public class 噪声传感器 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                int item = in.nextInt();
                array[i] = item;
            }
//            array = improvedbubble(array);
            int a = array[n/2] + 1;
//            int b = array[n-2] + 1;
            int b1,b2;
            int b = 0;
            int tem = 0;
            for (int i = 0; i < n-3; i++) {
                b1 = Math.max(array[i],array[i+3]);
                b2 = Math.min(array[i+2],array[i+1]);
                if (b1+1 <= b2-1) tem = b1 + 1;
                if (tem>b) b = tem;
            }
            System.out.println(Math.max(a,b));
        }
    }
    /*private static int[] improvedbubble(int[] data) {
        int tem;  //临时变量
        int flag;  //判断是否有执行交换的动作
        int size = data.length;//原始数组大小
        for (int i = size-1;i>0;i--) {
            flag = 0;
            for (int j = 0;j<i;j++) {
                //比较相邻两数.若第一数较大则交换
                if (data[j] > data[j+1]) {
                    tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                    flag++; //执行过交换 flag不为0
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return data;
    }*/
}
