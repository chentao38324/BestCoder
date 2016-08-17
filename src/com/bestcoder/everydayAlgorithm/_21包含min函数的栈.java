package com.bestcoder.everydayAlgorithm;

import java.util.Stack;

/**
 * Created by chentao on 16-8-8.
 * 在栈中增加一个min函数，能够得到栈中最小的元素
 *
 * 思路：借用辅助栈，我们把每一次最小的元素（之前栈中最小的元素和新压入栈的元素两者中的较小值）保存起来
 *      放到另一个辅助栈里
 */
public class _21包含min函数的栈 {
    public static void main(String[] args){
        ContainMinStack minStack = new ContainMinStack();
        minStack.push(3);
        System.out.println("栈中最小值为："+minStack.min());
        minStack.push(4);
        System.out.println("栈中最小值为："+minStack.min());
        minStack.push(2);
        System.out.println("栈中最小值为："+minStack.min());
        minStack.push(1);
        System.out.println("栈中最小值为："+minStack.min());
        minStack.pop();
        System.out.println("栈中最小值为："+minStack.min());
        minStack.pop();
        System.out.println("栈中最小值为："+minStack.min());
        minStack.pop();
        System.out.println("栈中最小值为："+minStack.min());
    }

    private static class ContainMinStack{
        private Stack<Integer> dataStack;   //原来的数据栈
        private Stack<Integer> minStack;    //辅助栈

        public ContainMinStack(){
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public int pop(){
            assert (dataStack.size() > 0 && minStack.size() > 0);//断言 true继续执行 false 报错
//            if (minStack.isEmpty()){
//                throw new RuntimeException("栈为空！");
//            }
            minStack.pop();     //辅助栈中的元素也跟着pop 这样剩下的栈顶元素就是数据栈中最小的元素
            return dataStack.pop();
        }
        public void push(Integer data){
            dataStack.push(data);
            if (minStack.isEmpty() || data < minStack.peek())
                minStack.push(data);
            else minStack.push(minStack.peek());
        }
        public int min(){
            assert (dataStack.size() > 0 && minStack.size() > 0);
            return minStack.peek();
        }
    }
}
