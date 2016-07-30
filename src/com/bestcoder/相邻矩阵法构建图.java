package com.bestcoder;

/**
 * Created by chentao on 16-4-22.
 */
public class 相邻矩阵法构建图 {
    public static void main(String[] args) {
        int[][] data = {{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},
                {2,4},{4,2},{3,4},{4,3},{3,5},{5,3},{4,5},{5,4}};
        //最大节点为5，声明二维矩阵
        int[][] arr = new int[5][5];
        int temi;
        int temj;
        for (int i = 0;i< data.length;i++) {
            temi = data[i][0]-1;
            temj = data[i][1]-1;
            arr[temi][temj] = 1;
        }
        //输出
        for (int i = 0; i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("["+arr[i][j]+"] ");
            }
            System.out.println();
        }
    }
}
