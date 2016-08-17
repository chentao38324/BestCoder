package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 求斐波那契数列 第n项
 * 除了第1,2项为0,1外其余每项等于前两项之和
 * 递归实现 代码简单效率很低
 * 循环实现 时间复杂度O(n)
 *
 * 拓展：青蛙跳台阶，一次只能调1或2级台阶，问跳到第n级台阶有多少种跳法
 *
 */
public class _9Fibonacci数列 {
    public static void main(String[] args){
        _9Fibonacci数列 instance = new _9Fibonacci数列();
        int m = 40;
        long timeStart,timeEnd;
        timeStart = System.currentTimeMillis();
        long n = instance.fibonacciInterative(m);
        timeEnd = System.currentTimeMillis();
        System.out.println("Fibonacci第40项循环实现："+n+" 运行时间(ms)："+(timeEnd-timeStart));
        timeStart = System.currentTimeMillis();
        n = instance.fibonacciRecursive(m);//非常非常慢
        timeEnd = System.currentTimeMillis();
        System.out.println("Fibonacci第40项递归实现："+n+" 运行时间(ms)："+(timeEnd-timeStart));
    }
    //循环实现
    public long fibonacciInterative(int n){
        if (n<2 && n>=0){
            return n;
        }
        long fn_1 = 1;
        long fn_2 = 0;
        long fn = 0;
        for (int i = 1; i < n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
    //递归 效率低 开发不会用
    public long fibonacciRecursive(int n){
        if (n<=0) return 0;
        if (n==1) return 1;
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }
    //青蛙跳n级台阶的跳法种数
    public long frogJumpStais(int n){
        if (n>=0 && n<=2){
            return n;
        }
        long fn_1 = 2;
        long fn_2 = 1;
        long fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = fn_2 + fn_1;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}
