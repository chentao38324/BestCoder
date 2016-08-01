package com.bestcoder.everydayAlgorithm;

import java.util.Scanner;

/**
 * Created by chentao on 16-7-31.
 *
 * 题目：二维数组中，每一行从左到右递增，每一列从上到下递增
 * 输入：二维数组，整数
 * 返回：是否含有这个整数
 * 思路：从右上角开始查找，如果大于要查找的数就剔除 列，小于剔除 行，等于返回true
 */
public class 二维数组中的查找 {
    public static boolean find(int[][] array,int num){
        int rowNum = array.length;//行数
        int columnNum = array[0].length;//列数

        int row = 0; //行从0增加
        int column = columnNum -1; //列从最后一列减
        int topRightNum;
        while (column > 0 && rowNum > row) {
            topRightNum = array[row][column]; //右上角的数
            if (topRightNum > num) {
                column--; //列减
            } else if (topRightNum < num) {
                row++; //行加
            } else {
                return true; //相等跳出
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int result = in.nextInt();
            System.out.println(find(array,result));
        }
    }
}
