package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-13.
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *      树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父节点的指针。
 *
 * 思路：三种情况
 *      1.如果一个节点有右子树，那么它的下一个节点就是它右子树中最左子节点
 *      2.该节点没有右子树，但它是父节点的左子节点，那么它的下一个节点就是它的父节点
 *      3.既没有右子树，而且是父节点的右子节点，可以沿着指向父节点的指针一直向上遍历，
 *        直到找到一个是它父节点的左子节点的节点，如果这样的节点存在，那么这个节点的父节点就是要找的下一个节点
 */
public class _58二叉树的下一个节点 {
    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null)
            return null;
        BinaryTreeNode resultNode; //结果
        if (node.right != null) {    //1.
            resultNode = node.right;
            while (resultNode.left != null) {
                resultNode = resultNode.left;
            }
            return resultNode;
        } else
        if (node.parent != null) {
            resultNode = node.parent;
            BinaryTreeNode curNode = node;
            while (resultNode != null && curNode != resultNode.left){
                curNode = resultNode;
                resultNode = resultNode.parent;
            }
            return resultNode;
        }
        return null;
    }

//        {  我写的 有问题
//            if (node == node.parent.left){     //2.
//                resultNode = node.parent;
//                return resultNode;
//            }else {     //3.
//                resultNode = node.parent;
//                while (resultNode.parent != null && resultNode == resultNode.parent.left){
//                    resultNode = resultNode.parent;
//                }
//                return resultNode;
//            }
//        }
//        return resultNode;
//    }

    private static class BinaryTreeNode{
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
        public BinaryTreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private static void assemble(BinaryTreeNode node,
                                 BinaryTreeNode left,
                                 BinaryTreeNode right,
                                 BinaryTreeNode parent) {
        node.left = left;
        node.right = right;
        node.parent = parent;
    }
    public static void main(String[] args) {
        //                            1
        //                  2                   3
        //             4         5          6          7
        //          8     9   10   11   12   13    14   15
        BinaryTreeNode n1 = new BinaryTreeNode(1); // 12
        BinaryTreeNode n2 = new BinaryTreeNode(2); // 10
        BinaryTreeNode n3 = new BinaryTreeNode(3); // 14
        BinaryTreeNode n4 = new BinaryTreeNode(4); // 9
        BinaryTreeNode n5 = new BinaryTreeNode(5); // 11
        BinaryTreeNode n6 = new BinaryTreeNode(6); // 13
        BinaryTreeNode n7 = new BinaryTreeNode(7); // 15
        BinaryTreeNode n8 = new BinaryTreeNode(8); // 4
        BinaryTreeNode n9 = new BinaryTreeNode(9); // 2
        BinaryTreeNode n10 = new BinaryTreeNode(10); // 5
        BinaryTreeNode n11 = new BinaryTreeNode(11); // 1
        BinaryTreeNode n12 = new BinaryTreeNode(12); // 6
        BinaryTreeNode n13 = new BinaryTreeNode(13); // 3
        BinaryTreeNode n14 = new BinaryTreeNode(14); // 7
        BinaryTreeNode n15 = new BinaryTreeNode(15); // null

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);

        System.out.println(getNext(n1).val);
        System.out.println(getNext(n2).val);
        System.out.println(getNext(n3).val);
        System.out.println(getNext(n4).val);
        System.out.println(getNext(n5).val);
        System.out.println(getNext(n6).val);
        System.out.println(getNext(n7).val);
        System.out.println(getNext(n8).val);
        System.out.println(getNext(n9).val);
        System.out.println(getNext(n10).val);
        System.out.println(getNext(n11).val);
        System.out.println(getNext(n12).val);
        System.out.println(getNext(n13).val);
        System.out.println(getNext(n14).val);
        System.out.println(getNext(n15));
    }
}
