package com.bestcoder.everydayAlgorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chentao on 16-8-12.
 * 题目：约瑟夫环问题
 *      0,1,2,...,n-1这n个数排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，求圆圈剩下的最后一个数字
 *      例如，0,1,2,3,4这5个数字组成一个圆圈，从0开始每次删除第三个数字，则删除的前四个数字依次是2,0,4,1最后剩3
 *
 * 方法一：用环形链表模拟圆圈，扫描到末尾的时候移到头部 注意如果删除最后一个元素 下次让从第一个开始遍历
 *      时间复杂度O(mn)
 *      空间复杂度O(n)
 *
 * 方法二：创新解法 分析法 推倒出公式
 *      f(n,m) = 0(n=1);[f(n-1,m)+m]%n (n>1)  可用递归和循环实现 下面用循环
 *      时间复杂度O(n)
 *      空间复杂度O(1)
 */
public class _45圆圈中最后剩下的数字 {
    public static void main(String[] args){
        int result = lastRemaining(5,3);
        System.out.println(result);//3
    }

    /**
     *
     * @param n  0,1,2,...,n-1这n个数排成一个圆圈
     * @param m 每次从这个圆圈里删除第m个数字
     * @return 圆圈剩下的最后一个数字
     */
    public static int lastRemaining(int n,int m){
        if (n < 1 || m < 1)
            return -1;
        int index = 0;  //下一个要删除的元素位置
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() > 1){
            for (int i = 0; i < m - 1; i++) {// 只要移动m-1次就可以移动到下一个要删除的元素上
                index++;
                if (index == list.size()){// 到尾部 指到头
                    index = 0;
                }
            }
            list.remove(index);
            //如果删除了最后一个元素 保证下次指向 第一个
            if (index == list.size()){
                index = 0;
            }
        }
        return list.get(0);
    }
    //方法二
    //f(n,m) = 0(n=1);[f(n-1,m)+m]%n (n>1)
    public static int lastRemaining2(int n,int m){
        if (n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
