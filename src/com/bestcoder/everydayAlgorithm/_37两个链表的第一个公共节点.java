package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-11.
 * 找出两个链表的第一个公共节点 Y型
 * 第一反应：蛮力法，在第一个链表顺序遍历每个节点，每遍历到一个节点时候，在第二个链表顺序遍历每个节点，
 *         如果第二个链表上又一个节点和第一个链表上的节点一样说明两个链表在这个节点上重合，
 *         如果两个链表长度为m和n 时间复杂度为O(mn)
 *
 * 解法2：公共节点会出现在链表的尾部，分别把两个链表的节点放入两个栈里，这样两个链表的尾节点就位于两个栈顶，
 *      接下来比较两个栈顶节点是否相同，相同，弹出比较下一个，直到找到最后一个相同的节点
 *      O(m+n)  ,  O(m+n)
 *
 * 解法3：首先遍历两个链表的长度，直到长的链表比短的链表多几个节点，第二次遍历时，在长的链表多走几步，然后同时遍历，
 *      直到找到它们第一个相同的节点
 *      O(m+n) 无空间复杂度
 */
public class _37两个链表的第一个公共节点 {
    public static void main(String[] args){
        ListNode node7 = new ListNode(7,null);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = findFirstCommonNode(node1,node4);
        System.out.println("相同节点的值:"+node.val);
    }

    public static ListNode findFirstCommonNode(ListNode head1,ListNode head2){
        if (head1 == null || head2 == null)
            return null;
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        int gap = len1 - len2;
        ListNode listNodeLong = head1;
        ListNode listNodeShort = head2;
        if ( len2 > len1){
            listNodeLong = head2;
            listNodeShort = head1;
            gap = len2 - len1;
        }
        while (gap>0){
            listNodeLong = listNodeLong.next;
            gap--;
        }
        while (listNodeLong != null && listNodeShort != null){
            if (listNodeLong == listNodeShort){
                return listNodeLong;
            }
            listNodeLong = listNodeLong.next;
            listNodeShort = listNodeShort.next;
        }
        return null;
    }

    private static int getListLength(ListNode head) {
        int len = 1;
        ListNode tem = head;
        while (tem.next != null){
            len++;
            tem = tem.next;
        }
        return len;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }

    }
}
