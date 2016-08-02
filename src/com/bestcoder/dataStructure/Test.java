package com.bestcoder.dataStructure;

/**
 * Created by chentao on 16-8-1.
 */
public class Test {
    public static void main(String[] args) {
        LinkList2 list = new LinkList2();
        for (int i = 0; i < 10; i++) {
            int tem = ((int)(Math.random()*100))%100;
            try {
                list.insert(i,tem);
                System.out.print(tem+" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            list.delete(4);
            System.out.println("\n ----删除第5个元素后---- ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
