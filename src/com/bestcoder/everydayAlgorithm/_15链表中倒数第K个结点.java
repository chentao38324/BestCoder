package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-7.
 * 陷阱：可能会导致程序崩溃的三种方法，都要去处理
 *     输入空链表
 *     k不是正数
 *     链表中少于k个节点
 *
 * 思路：用双指针，第一个指针先走K-1步，第二个指针开始走，
 * 之间差k-1步，等第一个指针走到尾节点 第二个指针刚好在倒数第k个节点（尾节点是倒数第1个 符合正常思维 不是0）
 *
 * 相关题目：
 * 1.求链表中间结点：如果链表结点为奇数（偶数）个，返回中间（中间两个任意一个）结点。
 * 思路：两个指针，同时从表头出发，一个指针一次走一步，另一个指针一次走两步，走得快的指针到尾节点时，走得慢的刚好到中间
 *
 * 2.判断一个单向链表是否形成环形结构。
 * 思路：两个指针，同时从表头出发，一个指针一次走一步，另一个指针一次走两步。
 * 如果走的快的指针追上了走的慢的指针，那么链表就是环形链表，如果走的快的指针走到了尾节点（next==null）
 * 都没有追上第一个指针，那么链表就不是环形链表
 *
 * 举一反三：当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表，让其中一个快一些，或者先走几步
 */
public class _15链表中倒数第K个结点 {
    public static void main(String[] args){

    }

    public static ListNode findKthToTail(ListNode head,int k){
        //这里有两种情况：链表为空，k值非正
        if (head == null || k <= 0){
            return null;
        }

        ListNode pFirst = head;
        ListNode pSecond = head;
        for (int i = 0; i < k-1; i++) {
            if (pFirst.next != null) {  //这里第三种情况 链表中少于k个节点
                pFirst = pFirst.next;
            }else {
                return null;
            }
        }
        while (pFirst.next != null){
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        return pSecond;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
