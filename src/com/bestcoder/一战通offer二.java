package com.bestcoder;

import java.util.Scanner;

/**
 * Created by chentao on 16-4-20.
 * 现在有一块长条形的土地，这个土地我们可以看成是由n块小方格连接而成的(这些小方格我们可以将之编号为1到n)。
 * 而我们需要将其划分成两个部分，分别种上不同的作物(即作物A和B)，
 * 划分必须在某两个小方格之间进行，或者在土地的最左端或最右端，
 * 若划分在第i块到第i+1块间进行，则划分后，第1至第i块地种A，剩下的地种B。
 * 现在有一些专家对土地进行了检测，他们每个人评估了每块土地适合种的作物。
 * 请你找到一个合适的划分，使得其与所有专家的评估最吻合，也就是说，
 * 你划分到A而专家评估为B的次数和你划分到B而专家评估为A的次数之和最小。
 */
public class 一战通offer二 {
    public static void main(String[] args) {
        int[][] data = {{1,1,1,1},{0,0,0,0},{1,0,1,1}};
        int[] result = getPartition(data,4,3);
        System.out.println(result[0]+" "+result[1]);
    }

    public static int[] getPartition(int[][] land, int n, int m) {
        // write code here
        int smallNum = m*n;
        int[] result = new int[2];
        for (int i = 0;i<n+1;i++) {
            int temp = 0;
            int temNum1 = i;
            while (temNum1>0) { //左边“1”个数
                for (int j = 0;j<m;j++) {
                    if (land[j][temNum1-1] == 1) {
                        temp += 1;
                    }
                }
                temNum1--;
            }
            int temNum2 = i;
            while (temNum2< n) { //右边“0”个数
                for (int j = 0;j<m;j++) {
                    if (land[j][temNum2] == 0) {
                        temp += 1;
                    }
                }
                temNum2++;
            }
            if (temp < smallNum) {
                smallNum = temp;
                result[0] = i;
                result[1] = i+1;
            }
        }
        return result;
    }
}
