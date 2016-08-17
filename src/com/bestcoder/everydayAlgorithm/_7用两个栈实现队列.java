package com.bestcoder.everydayAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chentao on 16-8-4.
 *  题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，
 *       分别完成在队列尾部插入结点和在队列头部删除结点的功能。
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
//        cStack.deleteTop();
    }

    /**
     * 两个栈实现队列
     * 入队：直接入栈1
     *
     * 出队：如果栈2为空，就把栈1全部移到栈2，出栈2
     * @param <T>
     */
    private static class CQueue<T> {
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
     * 入栈：如果队列1不为空，就把队列1全部移动到队列2，其实移动之后两个队列顺序一样的
     *      然后数据入队列1尾，
     *      此时，如果队列2不为空，就把队列2元素移回队列1，此时新加入的的元素就在队列1头部，
     * 出队：直接删除队列1的头即可
     * @param <T>
     */
    private static class CStack<T> {
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
}





