package com.bestcoder.everydayAlgorithm;

import com.bestcoder.dataStructure.Node2;

import java.util.Stack;

/**
 * Created by chentao on 16-8-2.
 */
public class _5从尾到头打印链表_链表 {
    public static void main(String[] args) {
        Node2 node5 = new Node2(null);
        node5.setElement(5);
        Node2 node4 = new Node2(4,node5);
        Node2 node3 = new Node2(3,node4);
        Node2 node2 = new Node2(2,node3);
        Node2 node1 = new Node2(1,node2);
        Node2 head = new Node2(null);
        head.setNext(node1);
        System.out.print("原始链表：");
        Node2 tem = head.getNext();
        while (tem.getNext() != null){
            System.out.print(tem.toString()+" ");
            tem = tem.getNext();
        }
        System.out.println("\n从尾到头打印：");
        //栈实现
        System.out.print("栈实现：");
        printReserveStack(head.getNext());
        //递归实现
        System.out.print("\n递归实现：");
        printReserveRecursion(head.getNext());
    }
    //栈实现
    private static void printReserveStack(Node2 head) {
        Stack<Integer> stack = new Stack<>();
        Node2 tem = head;
        while (tem != null){
            stack.push((int)tem.getElement());
            tem = tem.getNext();
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    //递归实现
    private static void printReserveRecursion(Node2 head) {
       if (head != null){
           if (head.getNext() != null){
               printReserveRecursion(head.getNext());
           }
       }
        System.out.print(head.getElement()+" ");
    }

}
