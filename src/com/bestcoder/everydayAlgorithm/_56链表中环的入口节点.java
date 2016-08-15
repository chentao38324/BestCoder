package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-13.
 * 题目：一个链表中包含环，如何找出环的入口结点？
 *
 * 思路：两个指针p1 p2，一快一慢 相遇时的节点一定在环中 （前提存在环），
 *      通过这个节点，转一周得到环的长度k
 *      重新遍历 p1先走k步，p2再走，相遇就是环的入口节点
 */
public class _56链表中环的入口节点 {

    public static void main(String[] args){
        // 1->2->3->4->5->6
        //       ^        |
        //       |        |
        //       +--------+
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        System.out.println(entryNodeOfLoop(n1).val);
    }

    //找到相遇的点 定在环中
    public static ListNode meetingNode(ListNode head){
        if (head == null)
            return null;
        ListNode pSlow = head.next;
        if (pSlow == null)
            return null;
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null){
            if (pFast == pSlow){
                return pFast;
            }
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null){
                pFast = pFast.next;
            }
        }
        return null; //如果链表不存在环 将返回null
    }

    //找入口
    public static ListNode entryNodeOfLoop(ListNode head){
        if (head == null)
            return null;
        ListNode meetNode = meetingNode(head);
        if (meetNode == null)
            return null;
        int nodeNumOfLoop = 1;
        ListNode tem = meetNode.next;
        while (meetNode != tem){
            tem = tem.next;
            nodeNumOfLoop++;
        }
        ListNode pNode1 = head;
        ListNode pNode2 = head;
        while (nodeNumOfLoop > 0){
            pNode1 = pNode1.next;
            nodeNumOfLoop--;
        }
        while (pNode2 != pNode1){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
}
