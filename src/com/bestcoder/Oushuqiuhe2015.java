package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-3-30.
 */
public class Oushuqiuhe2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            List<Integer> list = new ArrayList<>();
            int n = in.nextInt();
            int m = in.nextInt();
            if (n<=m){
                int temp = 0;
                for (int i = 0;i<n;i++) {
                    temp += 2*i+2;
                }
                System.out.println(temp/n);
            }else if (n>m){
                int groupNum;
                if (n%m ==0) {
                    groupNum = n / m;
                }else {
                    groupNum = n / m+1;
                }
                //循环groupNum-1组，留下最后一组 判断够不够m个
                for (int i = 0; i < groupNum-1; i++) {
                    int tem = 0;
                    for (int j = 1; j <m+1;j++) {
                        tem += 2*(i*m+j);
                    }

                    int result = tem/m;
                    list.add(i,result);
                }
                //最后一组两种情况 下面是不够m个
                if (n%m != 0) {
                    int tem = 0;
                    int lastgroupNum =n%m;
                    for (int k = 0;k<lastgroupNum;k++) {
                        tem += 2*((groupNum-1)*m+k+1);
                    }
                    int result = tem/lastgroupNum;
                    list.add(groupNum-1,result);
                }else {//够m个
                    int tem = 0;
                    for (int k = 0;k<m;k++) {
                        tem += 2*((groupNum-1)*m+k+1);

                    }
                    int result = tem/m;
                    list.add(groupNum-1,result);
                }
                String str = "";
                for (int i : list) {
                    str += i+" ";
                }
                System.out.println(str.trim());

            }

        }

    }

}
