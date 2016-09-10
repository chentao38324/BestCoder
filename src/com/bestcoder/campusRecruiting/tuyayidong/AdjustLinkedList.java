package com.bestcoder.campusRecruiting.tuyayidong;

/**
 * Created by chentao on 16-9-10.
 * 链表变换-涂鸦移动笔试
 * 1将链表中的所有元素为奇数的节点移到元素为偶数节点的前面，并使奇数之间顺序反转，偶数之间顺序反转。

 示例：
 交换前链表的顺序		交换后链表的顺序
 4→5→7→1→6   ==>  1→7→5→6→4
 1                ==>  1			（链表仅含一个元素)
 2→1            ==>  1→2
 ==>				(链表为空)

 Java:
 链表节点定义为：
 class Node {
 public Node next;
 public int value
 }
 Node swap(Node list)

 注意点和要求如下:
 1. swap函数要求对节点的指针/引用进行操作（不得创建任何新的链表节点）
 2. 不得使用任何库函数/API，如需使用类似功能, 请自行实现
 3. 不得将链表转化为其他类型数据结构再进行交换，如数组等
 */

/**
 * 思路：先翻转链表  再将奇数节点调整到偶数节点之前
 */
public class AdjustLinkedList {
    public static void main(String[] args) {
        Node node5 = new Node(6,null);
        Node node4 = new Node(1,node5);
        Node node3 = new Node(7,node4);
        Node node2 = new Node(5,node3);
        Node node1 = new Node(4,node2);
        Node tem = node1;
        System.out.println("原始链表：");
        printNode(tem);

        Node result = swap(node1);

        Node tem1 = result;
        System.out.println("变换链表：");
        printNode(tem1);

    }


    private static Node swap(Node list) {
        if (list == null) return null;
        return adjustNode(reverseNode(list));
    }

    //调整函数
    //调整函数 主要用到3个指针  一个当前节点 ，一个当前奇数节点  一个当前偶数节点
    private static Node adjustNode(Node list) {
        Node pOddHead = null;
        Node pEvenHead = null;
        Node pNode = list;
        Node pOddNode = null;
        Node pEvenNode = null;
        while (pNode != null) {
            if (pNode.value % 2 == 0 && pEvenHead == null) { //第一个偶数节点
                pEvenHead = pNode;
                pEvenNode = pNode;
            }else if (pNode.value % 2 != 0 && pOddHead == null){ //第一个奇数节点
                pOddHead = pNode;
                pOddNode = pNode;
            }else {
                if (pNode.value % 2 == 0){ //非偶数头节点的偶数节点
                    pEvenNode.next = pNode;
                    pEvenNode = pNode;
                }else {
                    pOddNode.next = pNode;
                    pOddNode = pNode;
                }
            }
            pNode = pNode.next;
        }
        pOddNode.next = pEvenHead;
        return pOddHead;
    }

    //链表翻转
    //翻转链表用到三个指针 分别保存 前一个节点 当前节点 后一个节点
    private static Node reverseNode(Node list) {
        Node reverseHead = null;
        Node pNode = list;
        Node pPre = null;
        while (pNode != null){
            Node pNext = pNode.next;
            if (pNext == null){
                reverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return reverseHead;
    }

    private static void printNode(Node tem) {
        while (tem != null){
            if (tem == null) {
                System.out.println("null");
                break;
            }
            if (tem.next == null){
                System.out.println(tem.value);
            }else {
                System.out.print(tem.value + "->");
            }
            tem = tem.next;
        }
    }

    static class Node {
        public Node next;
        public int value;
        public Node(int val,Node next){
            this.value = val;
            this.next = next;
        }
    }
}

