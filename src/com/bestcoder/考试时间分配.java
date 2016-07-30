package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-8.
 */
public class 考试时间分配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int minsumTime = 0;
            int iminTime,imaxTime,idurTime;
            List<Integer> maxTimeList = new ArrayList<>();
            List<Integer> minTimeList = new ArrayList<>();
            List<Integer> durTimeList = new ArrayList<>();
            List<Integer> resultTimeList = new ArrayList<>();

            int d = in.nextInt();
            int sumTime = in.nextInt();//总时间
            int perHour = (int) Math.ceil((double)sumTime/d);
            boolean perDay = perHour<=24;
            System.out.println(perDay);

            boolean studyTime = true;
            for (int i = 0;i<d;i++) {
                iminTime = in.nextInt();

                minsumTime += iminTime;
                minTimeList.add(i,iminTime);

                imaxTime = in.nextInt();
                maxTimeList.add(i,imaxTime);

                idurTime = imaxTime-iminTime;
                durTimeList.add(i,idurTime);
                if (iminTime>=0&&iminTime<=imaxTime&&iminTime<=8&&imaxTime>=0&&imaxTime<=8){
                }else {
                    studyTime = false;
                }
            }
            if (perDay&&(d>=1&&d<=30)&&(sumTime>=0&&sumTime<=240)&&studyTime) {
                if (minsumTime <= sumTime) {
                    System.out.println("Yes");
                    for (int i = 0; i < d; i++) {
                        resultTimeList.add(i, minTimeList.get(i));
                    }
                    int relaxTimeSum = sumTime - minsumTime;
                    if (relaxTimeSum > 0) {
                        for (int i = 0; i < d; i++) {
                            if (relaxTimeSum > maxTimeList.get(i) - minTimeList.get(i)) {
                                relaxTimeSum -= maxTimeList.get(i) - minTimeList.get(i);
                                resultTimeList.set(i, maxTimeList.get(i));
                            } else if (relaxTimeSum > 0 &&
                                    relaxTimeSum <= maxTimeList.get(i) - minTimeList.get(i)) {
                                resultTimeList.set(i, resultTimeList.get(i) + relaxTimeSum);
                            } else if (relaxTimeSum == 0) {
                                return;
                            }
                        }
                    }
                    String resultt = "";
                    for (int i = 0; i < d; i++) {
                        resultt += resultTimeList.get(i) + " ";
                    }
                    System.out.println(resultt.trim());
                } else {
                    System.out.println("No");
                }
            }else {
                System.out.println("No");
            }

        }
    }
}
