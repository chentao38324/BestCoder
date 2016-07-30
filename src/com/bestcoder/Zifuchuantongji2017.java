package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Zifuchuantongji2017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            String n = in.nextLine();
            int nn = Integer.valueOf(n);
            list.clear();
            for (int i =0;i<nn;i++) {
                String line = in.nextLine();
                list.add(i,numLenth(line).length());
            }
            for (int result : list) {
                System.out.println(result);
            }
        }

    }

    private static String numLenth(String line) {
        String str = "";
        for (int i =0;i<line.length();i++){
            if (line.charAt(i)>=48&&line.charAt(i)<=57){
                str+=line.charAt(i);
            }
        }
        return str;
    }
}
