package com.bestcoder.dataStructure;

/**
 * Created by chentao on 16-8-1.
 */
public class LinkList1<T> {

    private Node<T> head;//链表头节点
    private Node<T> tail;//链表尾节点

    /**
     * 构造一个空链表
     */
    public LinkList1(){
        head = tail = null;
    }
    /**
     * 链表内部节点类
     * @param <T>
     */
    private static class Node<T>{
        T data;         //节点数据
        Node<T> next;   //该节点指向下一节点的指针

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 为空链表增加头节点
     * @param point
     */
    public void addHead(T point) {
        this.head = new Node<>(point);
        if (tail == null){
            tail = head;
        }
    }

    /**
     * 为链表添加尾节点
     * @param point
     */
    public void addTail(T point) {
        this.tail = new Node<>(point);
        head.next = tail;
    }

    /**
     * 插入节点
     * @param point
     */
    public void insert(T point) {
        if (head == null){
            addHead(point);
        }else if (tail == head){
            addTail(point);
        }else {
            Node<T> newNode = new Node<>(point);
            Node<T> preNode = head.next;
            head.next = newNode;
            newNode.next = preNode;
        }
    }

    /**
     * 打印链表
     */
    public void printLinkList(){
        Node<T> curr = head;
        if (isEmpty()) {
            try {
                throw new Exception("linklist is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    /**
     * 删除节点
     * @param data
     */
    public void delete(T data) {
        Node<T> curr = head;
        Node<T> pre = null;
        boolean suc = false;    //是否删除成功

        while (curr != null){
            if (curr.data.equals(data)) {
                //判断是什么节点
                if (curr == head) {
                    System.out.println("\n" + "删除头节点");
                    head = head.next;
                    suc = true;
                    break;
                }
                if (curr == tail) {
                    System.out.println("\n" + "删除尾节点");
                    tail = pre;
                    tail.next = null;
                    suc = true;
                    break;
                } else {
                    System.out.println("\n" + "删除中间节点");
                    pre.next = curr.next;
                    suc = true;
                    break;
                }
            }
            pre = curr;
            curr = curr.next;
        }
        if (suc == false){
            System.out.println("\n"+"没有这个数据");
        }
    }

    public boolean isEmpty(){
        return head==null || tail==null;
    }

    public static void main(String[] args){
        LinkList1<Integer> mylist = new LinkList1<>();//构建一个空链表
        mylist.insert(5);
        mylist.insert(6);
        mylist.insert(7);
        mylist.insert(3);
        mylist.printLinkList();
        mylist.delete(1);
        mylist.printLinkList();
        mylist.delete(5);
        mylist.printLinkList();
        mylist.delete(6);
        mylist.printLinkList();
    }
}
