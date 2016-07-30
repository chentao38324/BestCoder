package com.bestcoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-20.
 */
public class 阿里笔试 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int testNum = in.nextInt();
            for (int i = 0;i<testNum;i++) {
                String data = in.next();
                if (isRC(data)) {//RC格式
                    String result = changeToNo(data);
                    System.out.println(result);
                }else {//非RC格式
                    String result = changeToRC(data);
                    System.out.println(result);
                }
            }
        }


    }

    private static String changeToRC(String data) {
        char[] array1 = data.toCharArray();
        int inNum = 0;
        for (int i = 0;i<array1.length;i++){
            if (array1[i]>=48&&array1[i]<=57){
                inNum = i;
                break;
            }
        }
        String preData = data.substring(0,inNum);
        String preResult = data.substring(inNum);
        double temp = 0;
        char[] array = preData.toCharArray();
        for (int i = array.length-1;i>=0;i--) {
            temp  = temp + ((int)array[i] - 64)*Math.pow(26,array.length-1-i);
        }
        return "R"+preResult+"C"+(int)temp;
    }

    private static String changeToNo(String data) {
        String result = "";

        String numberLast = data.substring(data.indexOf("R")+1,data.indexOf("C"));
        String toChangeStr = data.substring(data.indexOf("C")+1);
        int numberNum = Integer.valueOf(toChangeStr);
        ArrayList<Character> list = new ArrayList<>();
        char temChar;
        int temInt;
        int j = 0;
        while (numberNum>0) {
            temInt = numberNum%26 + 64;
            temChar = (char)temInt;
            list.add(j++,temChar);
            numberNum /= 26;
        }
        for (int k = list.size()-1;k>=0;k--) {
            result += list.get(k)+"";
        }
        return result+numberLast;
    }

    private static boolean isRC(String data) {
        if (data.contains("R")){
            if (data.contains("C")){
                try {
                    char number = data.substring(data.indexOf("R")+1,data.indexOf("C")).charAt(0);
                    if (number>=48&&number<=57) {
                        return true;
                    }
                }catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
