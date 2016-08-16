package com.bestcoder.everydayAlgorithm;


import java.util.Stack;

/**
 * Created by chentao on 16-8-2.
 * 题目：输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 * 
 * 思路：从尾到头打印 从前向后遍历，放入栈 先入后出可实现
 * 递归实现，递归本质是一个栈，每访问到一个节点的时候，先递归输出它后面的节点，在输出该节点自身
 */
public class _5从尾到头打印链表_链表 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode ListNode = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,ListNode);
        System.out.print("原始链表：");
        ListNode tem = node1;
        while (tem != null){
            System.out.print(tem.val+" ");
            tem = tem.next;
        }
        System.out.println("\n从尾到头打印：");
        //栈实现
        System.out.print("栈实现：");
        printReserveStack(node1);
        //递归实现
        System.out.print("\n递归实现：");
        printReserveRecursion(node1);
    }
    //栈实现
    private static void printReserveStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tem = head;
        while (tem != null){
            stack.push(tem.val);
            tem = tem.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    //递归实现
    private static void printReserveRecursion(ListNode head) {
        if (head != null && head.next != null) {
            printReserveRecursion(head.next);
        }
        System.out.print(head.val+" ");
    }

    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
