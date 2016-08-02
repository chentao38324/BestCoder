package com.bestcoder.dataStructure;

/**
 * Created by chentao on 16-8-1.
 * 结点类
 */
public class Node2 {
    Object element; //数据域
    Node2 next;  //指针域

    //头结点的构造方法
    public Node2(Node2 nextval) {
        this.next = nextval;
    }

    //非头结点的构造方法
    public Node2(Object obj, Node2 nextval) {
        this.element = obj;
        this.next = nextval;
    }

    //获得当前结点的指针域
    public Node2 getNext() {
        return this.next;
    }

    //获得当前结点数据域的值
    public Object getElement() {
        return this.element;
    }
    //设置当前结点的指针域
    public void setNext(Node2 nextval) {
        this.next = nextval;
    }

    //设置当前结点数据域的值
    public void setElement(Object obj) {
        this.element = obj;
    }

    public String toString() {
        return this.element+"";
    }
}
