package com.bestcoder.confusionCode;

/**
 * Created by chentao on 16-4-22.
 */
public class 相邻表法建图 {
    public static void main(String[] args) {
        int[][] data = {{1,2},{2,1},{1,5},{5,1},{2,3},{3,2},{2,4},
                {3,4},{4,2},{4,3},{3,5},{5,3},{4,5},{5,4}};
        GraphLink[] result = new GraphLink[6];
        int temp;
        for (int i = 1;i<6;i++) {
            result[i] = new GraphLink();
            for (int j = 0;j<14;j++) {
                if (data[j][0] == i) {
                    temp = data[j][1];
                    result[i].insert(temp);
                }
            }
            System.out.print("顶点"+i+"=>");
            result[i].print();
        }
    }

    private static class GraphLink {
        public Node first;
        public Node last;

        public boolean isEmpty(){
            return first == null;
        }

        public void print(){
            Node current = first;
            while (current != null) {
                System.out.print("["+current.value+"]");
                current = current.next;
            }
            System.out.println();
        }

        public void insert(int val) {
            Node newNode = new Node(val);
            if (this.isEmpty()) {
                first = newNode;
                last = newNode;
            }else {
                last.next = newNode;
                last = newNode;
            }
        }
    }

    private static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}