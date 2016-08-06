package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-6.
 * 一般做法：O(n)从头遍历链表 发现结点h的next指针指向要删除的i结点，把h的next指针指向i的下一结点j
 *
 * 思路：O(1)不用遍历可以找到i节点的下一结点j，把j节点内容复制到要删除的i结点覆盖原有内容，
 * 再把i节点的next指针指向j的下一结点
 * 时间复杂度 对于n-1个非尾节点而言，可以在O(1)时间删除，
 * 对于尾节点，要顺序查找时间复杂度O(n)
 * 总的时间复杂度是[(n-1)*O(1)+O(n)]/n 结果还是O(1)
 * 但是，此算法基于一个假设：要删除的节点确实在链表中，我们要O（n）的时间才能判断链表中是否包含某一节点，
 * 受到O(1)限制，我们要把确保节点在链表中的责任给deleteNode函数的调用者。
 */
public class _13在O1时间删除链表结点 {

    public static void deleteNode(ListNode pListHead,ListNode pToBeDelete){
        if (pListHead == null || pToBeDelete == null) return;

        //要删除的节点不是尾节点
        if (pToBeDelete.next != null){
            pToBeDelete.value = pToBeDelete.next.value;
            pToBeDelete.next = pToBeDelete.next.next;
        }else if (pListHead == pToBeDelete){//只有一个头节点也是尾节点
            pListHead = null;
            return;
        }else {//删除尾节点
            ListNode preDeleteNode = pListHead;
            while (preDeleteNode != pToBeDelete){
                preDeleteNode = preDeleteNode.next;
            }
            preDeleteNode.next = null;
        }

    }

    private static class ListNode {
        int value;
        ListNode next;
    }
}
