package com.bestcoder.confusionCode;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-29.
 * 给定一个日期，输出这个日期是该年的第几天。
 */
public class Dijitain2005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int days = 0;
            int day_sum = 0;
            String date_str = in.nextLine();
            String[] date_int = date_str.split("/");
            int year = Integer.valueOf(date_int[0]);
            int month = Integer.valueOf(date_int[1]);
            int day = Integer.valueOf(date_int[2]);
            for (int i = 1;i<month;i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        days = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        days = 30;
                        break;
                    case 2:
                        if ((year%400 == 0)||((year%4 == 0)&&(year%100 != 0))){
                            days = 29;
                        }else {
                            days = 28;
                        }
                        break;
                }
                day_sum += days;
            }
            int result = day_sum+day;
            System.out.println(result);
        }

    }
}
