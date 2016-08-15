package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-13.
 * 题目：在一个排序的链表中，如何删除重复的结点？
 *
 * 链表中结点的删除，最关键的就是不能断链。在删除的过程中，被删除结点的前一个结点的指针必须保存，
 * 这样才不会断链，所以必须存在一个指针preNode。
 */
public class _57删除链表中重复的节点 {

    public static void main(String[] args){
        // 1->2->3->3->4->4->5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    public static ListNode deleteDuplication(ListNode head){
        if (head == null)
            return null;
        ListNode root = new ListNode(); //临时头节点
        root.next = head;
        ListNode preNode = root;        // 记录前驱结点
        ListNode curNode = head;        // 记录当前处理的结点
        while (curNode != null && curNode.next != null){
            if (curNode.val == curNode.next.val){
                // 找到下一个不同值的节点，注意其有可能也是重复节点
                while (curNode.next != null && curNode.val == curNode.next.val){
                    curNode = curNode.next;
                }
                // 指向下一个节点，prev.next也可能是重复结点
                // 所以prev不要移动到下一个结点
                preNode.next = curNode.next;
            }else { // 相邻两个值不同，说明node不可删除，要保留
                preNode.next = curNode;
                preNode = preNode.next;
            }
            curNode = curNode.next;
        }
        return root.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(){

        }
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
