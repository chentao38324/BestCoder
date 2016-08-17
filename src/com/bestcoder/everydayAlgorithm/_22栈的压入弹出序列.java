package com.bestcoder.everydayAlgorithm;

import java.util.Stack;

/**
 * Created by chentao on 16-8-8.
 * 输入两个序列，第一个是栈的压入序列，判断第二个序列是不是弹出序列
 *
 * 思路：用辅助栈，遍历弹出序列，如果辅助栈中下一个要弹出的数字刚好是当前遍历到的弹出序列的数字，直接弹出，
 *      如果下一个要弹出的数字不在辅助栈栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈
 *      直到把下一个要弹出的数字压入栈顶为止。
 *      如果所有的数组都压入了栈，仍然没有找到下一个弹出的数字，那么第二个序列不可能是弹出序列
 */
public class _22栈的压入弹出序列 {
    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(isPopOrder(push,pop)+"");
    }

    public static boolean isPopOrder(int[] push,int[] pop){
        if (push == null || pop == null || push.length != pop.length)
            return false;
        Stack<Integer> helpStack = new Stack<>();
        int tem;
        int pPush = 0;      //记录哪些元素已压入栈
        for (int i = 0; i < pop.length; i++) {  //遍历弹出序列
            tem = pop[i];
            if (helpStack.size() == 0 || helpStack.peek() != tem){
                for (int j = pPush; j < push.length; j++) { //遍历压入序列
                    pPush++;
                    if (push[j] != tem) {
                        helpStack.push(push[j]);
                    }else {
                        helpStack.push(push[j]);
                        break;
                    }
                }
            }
            if (helpStack.size() != 0 && helpStack.peek() == tem){
                helpStack.pop();
            }
        }
        if (pPush == push.length && helpStack.size() == 0)
            return true;
        return false;
    }
}
