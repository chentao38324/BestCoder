package com.bestcoder.网易内推笔试;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chentao on 16-8-2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] array = str.split(",");
            String tem = "";
            Stack<String> reserve = new Stack<>();
            List<String> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            int k = 0;
            for (String item : array) {
                if (i == 0 || i == 2 || i == 6 || i == 14 || i == 30 || i == 62 || i == 126 || i == 254 || i == 510 || i == 1022) {
                    if (item.equals("0")) {
//                    System.out.println("");
                        tem = tem.trim();
                    } else {
//                    System.out.println(item);
                        tem += item;
                    }
                    reserve.push(tem);
                    list.add(j++, tem);
                    tem = "";
                } else {
                    if (item.equals("0")) {
//                    System.out.print("");
                    } else {
//                    System.out.print(item+" ");
                        tem += item + " ";
                    }
                    if (i == array.length - 1) {
                        tem = tem.trim();
                        reserve.push(tem);
                        list.add(j++, tem);
                    }
                }
                i++;
            }
            for (String item : list) {
                System.out.println(list.get(k++));
            }
            System.out.println();
            while (!reserve.isEmpty()) {
//                if (reserve.size() == 1) {
//                    System.out.print(reserve.pop());
//                } else {
                    System.out.println(reserve.pop());
//                }
            }

        }
    }
}
