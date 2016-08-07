package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 */
public class _17合并两个排序的链表 {
    public static ListNode mergeTwoListNode(ListNode pHead1,ListNode pHead2){
        if (pHead1 == null){
            return pHead2;
        }else if (pHead2 == null){
            return pHead1;
        }
        ListNode pMergeHead = null;
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
