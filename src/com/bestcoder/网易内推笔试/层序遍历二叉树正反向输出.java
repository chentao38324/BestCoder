package com.bestcoder.网易内推笔试;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-8-2.
 */
public class 层序遍历二叉树正反向输出 {
    private static List<Node> nodeList = null;
    private static Node root;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = { 1, 2, 3, 0,4, 5, 6, 7, 8, 9 };

//        while (in.hasNext()) {//注意while处理多个case
            createBinTree(array);
            layerOrder(nodeList.get(0));
//        }
    }

    public static void createBinTree(int[] array) {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new Node(array[i]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int i = 0; i < array.length / 2 - 1; i++) {
            // 左孩子
            nodeList.get(i).left = nodeList
                    .get(i * 2 + 1);
            // 右孩子
            nodeList.get(i).right = nodeList
                    .get(i * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    public static void layerOrder(Node root) {
        // 创建队列
        ArrayList<Node> q = new ArrayList<Node>();
        q.add(root);

        while (q.size() > 0) {
            // 出列
            root = (Node) q.get(0);
            q.remove(0);

            // 访问队列头部节点
            System.out.print(root.data + " ");
            if (root.left != null)
                // 将节点的左子节点保存至队列
                q.add(root.left);
            if (root.right != null)
                // 将节点的右子节点保存至队列
                q.add(root.right);
        }
    }
}


class Node {
    int data;
    Node left;
    Node right;

    Node(int newData) {
        left = null;
        right = null;
        data = newData;
    }
}
