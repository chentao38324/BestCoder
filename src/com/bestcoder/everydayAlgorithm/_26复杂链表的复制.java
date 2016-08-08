package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-8.
 * 题目：复制一个复杂链表，复杂链表中每个节点除了next指针指向下一个节点外，
 *      还有一个Sibling指针指向任意一个节点或者null
 *
 * 方法一：O(n²)
 *      第一步：复制原来链表的每个节点，用next链接起来；
 *      第二步：设置每个节点的Sibling指针。
 *      每次复制Sibling时都要遍历一遍，n个节点遍历n次就是O(n²)
 *
 * 方法二：O(n) 但是用O(n) 的辅助空间
 *      第一步：同上，同时把<N,N'>的配对信息放到一个哈希表中。
 *      第二步：有了哈希表不用每次遍历 可以用O(1)时间找到对应N'的S'
 *
 * 方法三：O(n) 不用辅助空间
 *      第一步：同1，这一次我们把N'链接在N后面
 *      第二步：设置复制出来的节点的siblinig指针，原链表N.sibling=S
 *             则复制的链表中N'=N.next,S'=S.next
 *      第三步：把这个长链表拆分成两个链表：把奇数位置的节点用next连起来就是原始链表，
 *            把偶数位置连起来就是复制出来的链表。
 */
public class _26复杂链表的复制 {

    //第一步
    public static void cloneNodes(ListNode head){
        ListNode temNode = head;
        while (temNode != null){
            ListNode clonedNode = new ListNode(temNode.val);
            clonedNode.next = temNode.next;
            clonedNode.sibling = null;

            temNode.next = clonedNode;
            temNode = clonedNode.next;
        }
    }

    //第二步
    public static void connectSiblingNodes(ListNode head){
        ListNode temNode = head;
        while (temNode != null){
            ListNode cloneNode = temNode.next;
            if (temNode.sibling != null){
                cloneNode.sibling = temNode.sibling.next;
            }
            temNode = cloneNode.next;
        }
    }

    //第三步
    public static void reconnectNodes(ListNode head){
        ListNode temNode = head;
        ListNode clonedHead = null;
        ListNode clonedNode = null;

        if (temNode)
    }

    //复杂链表
    private static class ListNode {
        int val;
        ListNode next;      //指向下一个节点
        ListNode sibling;   //指向任意一个节点
        public ListNode(int val){
            this.val = val;
            this.next = null;
            this.sibling = null;
        }
    }
}
