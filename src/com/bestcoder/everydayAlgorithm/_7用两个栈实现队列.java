package com.bestcoder.everydayAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chentao on 16-8-4.
 *
 */
public class _7用两个栈实现队列 {
    public static void main(String[] args){
        //队列测试
        CQueue<Integer> cQueue = new CQueue<>();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println("队列测试：入队1 2 3 出队为：");
        for (int i = 0; i < 3; i++) {
            System.out.print(cQueue.deleteHead()+" ");
        }

        //栈测试
        CStack<Integer> cStack = new CStack<>();
        cStack.appendTop(4);
        cStack.appendTop(5);
        cStack.appendTop(6);
        System.out.println("\n栈测试：入栈4 5 6 出栈为：");
        for (int i = 0; i < 3; i++) {
            System.out.print(cStack.deleteTop()+" ");
        }
        cStack.deleteTop();
    }
}

/**
 * 两个栈实现队列
 * @param <T>
 */
class CQueue<T> {
    //两个栈
    Stack<T> stack1;
    Stack<T> stack2;

    public CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    /**
     * 入队
     * @param val 值
     */
    void appendTail(T val){
        stack1.push(val);
    }

    /**
     * 出队
     * @return 弹出的元素
     */
    T deleteHead(){
        if (stack2.isEmpty()){
            //队列为空
            if (stack1.isEmpty()){
                try {
                    throw new Exception("队列为空！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

/**
 * 两个队列实现栈
 * @param <T>
 */
class CStack<T> {
    //两个队列
    Queue<T> queue1;
    Queue<T> queue2;

    public CStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //入栈
    void appendTop(T val){
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        queue1.add(val);
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
    }

    //出栈
    T deleteTop(){
        if (queue1.isEmpty()){
            try {
                throw new Exception("栈为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return queue1.poll();
    }
}
