package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-1.
 */
public class 排序1106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] raw_date = line.split("5");
            List<String> list = new ArrayList<>();

            //组装成list
            int k = 0;
            for (int j = 0;j<raw_date.length;j++) {
                String dateItem = raw_date[j];
                if (!dateItem.equals("")) {
                    if (Integer.valueOf(dateItem) != 0) {
                        list.add(k++,dateItem);
                    }else {
                        dateItem = "0";
                        list.add(k++,dateItem);
                    }
                }else {
//                    list.remove(j);
//                    break;
                }

            }
            for (int j = 0;j<list.size();j++) {
                //去0
                for (int i = 0;i<list.get(j).length();i++) {
                    list.set(j,Integer.valueOf(list.get(j)).toString()) ;
//                    if (list.get(j).charAt(i) == '0') {
//                        list.set(i,list.get(j).substring(i+1,list.size())) ;
//                    }else {break;}
                }
            }
            //排序
            for (int i = 0; i <list.size();i++) {
                for (int j = i+1;j<list.size();j++) {
                    if (Integer.valueOf(list.get(i)) > Integer.valueOf(list.get(j))) {
                        String tem = list.get(i);
                        list.set(i,list.get(j));
                        list.set(j,tem);
                    }
                }
            }
            String result = "";
            for (String str : list) {
                result += str+" ";
            }
            System.out.println(result.trim());
        }

    }
}
