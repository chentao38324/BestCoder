package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * 假设已经把h节点之前的指针调整完毕，这些节点的next都指向前一个节点。h下一节点是i，i后是j
 * 接下来我们把i的next 指向h，此时链表在i处断裂，导致无法遍历到j节点，因此需要在调整节点i的next之前把j保存下来
 *
 * 思路：定义三个指针 当前节点，前面节点 和后面节点
 */
public class _16反转链表 {
    public static void main(String[] args){

    }
    public static ListNode reverseList(ListNode head){
        ListNode pReverseHead = null;
        ListNode pNode = head;
        ListNode pPre = null;
        while (pNode != null){
            ListNode pNext = pNode.next;
            if (pNext == null){
                pReverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
