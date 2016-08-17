package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-8.
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 * 从外到内顺时针打印，看成从外到内一圈一圈打印
 * 最后一圈 可能不会完整四步都打印出来 要有限制条件
 *
 * 思路：每一圈选取左上角的元素（横纵坐标相等为start）为分析目标
 *      循环继续的条件是rows > start*2 && columns >start*2
 *      每圈可分为四步，考虑最后一圈 每步的条件
 */
public class _20顺时针打印矩阵 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixClockwisely(matrix);
    }

    public static void printMatrixClockwisely(int[][] numbers){
        if (numbers == null || numbers.length < 1)
            return;
        int rows = numbers.length;
        int columns = numbers[0].length;
        int start = 0;//第一圈左上角的坐标（start，start）

        while (rows > start*2 && columns >start*2){ //继续循环
            printMatrixInCircle(numbers,columns,rows,start);
            start++;
        }
    }

    private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns-1-start;
        int endY = rows-1-start;
        int number;
        //从左到右打印一行 条件1：无
        for (int i = start; i <= endX; i++) {
            number = numbers[start][i];
            System.out.print(number+" ");
        }
        //从上到下打印一列 条件2：终止行号>起始行号
        if (start < endY){
            for (int i = start+1; i <= endY; i++) {
                number = numbers[i][endX];
                System.out.print(number+" ");
            }
        }
        //从右到左打印一行 条件3：条件2+终止列号 > 起始列号
        if (start < endX && start <endY){
            for (int i = endX-1; i >= start ; i--) {
                number = numbers[endY][i];
                System.out.print(number+" ");
            }
        }
        //从下到上打印一列 条件4：终止行号比起始行号大2 + 终止列号 > 起始列号
        if (start < endY-1 && start <endX){
            for (int i = endY-1; i > start; i--){
                number = numbers[i][start];
                System.out.print(number+" ");
            }
        }
    }
}
