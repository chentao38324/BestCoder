package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
 *
 * 思路：处理空链表 比较哪个节点值小，然后递归为节点值next
 */
public class _17合并两个排序的链表 {

    public static ListNode mergeTwoListNode(ListNode pHead1,ListNode pHead2){
        if (pHead1 == null){
            return pHead2;
        }else if (pHead2 == null){
            return pHead1;
        }
        ListNode pMergeHead;
        if (pHead1.val < pHead2.val){
            pMergeHead = pHead1;
            pMergeHead.next = mergeTwoListNode(pHead1.next,pHead2);
        }else {
            pMergeHead = pHead2;
            pMergeHead.next = mergeTwoListNode(pHead1,pHead2.next);
        }
        return pMergeHead;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
