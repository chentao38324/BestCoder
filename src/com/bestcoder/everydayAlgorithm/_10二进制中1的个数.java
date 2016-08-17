package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 题目：输入一个整数，输出该数二进制表示中1的个数
 *
 * 结论：把一个数-1再和原来的数相与，会把原来整数最右边一个1变成0 很多二进制问题可以用这个解决
 * 三种方法
 */
public class _10二进制中1的个数 {
    public static void main(String[] args){
        int n = -15;
        int method1 = numberOfOne1(n);
        int method2 = numberOfOne2(n);
        int method3 = numberOfOne3(n);
        System.out.println("方法一："+method1+"\n方法二："+method2+"\n方法三："+method3);
    }



    //方法一：从整数右边开始判断右边第一位是不是1（用整数和1做与运算，=1是1，=0不是1）然后整数无符号右移1位（n>>>1）
    public static int numberOfOne1(int n){
        int count = 0;      //记录1的个数
        while (n != 0){
            if ((n&1)==1){
                count++;
            }
            n = n >>> 1;  //n无符号右移1位  若直接右移（>>） 输入负数时候可能会 出现死循环
        }
        return count;
    }
    //方法二：不移动n，移动1，先将n和1与运算，知道最右边一位是不是1（=1是1，=0不是1）
    // 然后1左移一位，n和1与运算，知道右边倒数第二位是不是1
    private static int numberOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n&flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }

    //方法三：1和2都需要循环n的位数次 下面这种方法 n中多少各1 就循环多少次 好方法
    /**
     * 结论：把一个数-1再和原来的数相与，会把原来整数最右边一个1变成0，有多少个1 就会执行多少次
     */
    private static int numberOfOne3(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

}
