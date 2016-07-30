package com.bestcoder;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
public class 免费馅饼1176
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int[][] set;
        int num,x,t;
        while(true)
        {
            set=new int[100005][13];
            num=cin.nextInt();
            if(num==0)	break;

            int max_t=-1;
            for(int i=1;i<=num;++i)
            {
                x=cin.nextInt();
                t=cin.nextInt();

                max_t=max_t>t?max_t:t;
                ++set[t][x+1];
            }

            for(int i=max_t-1;i>=0;--i)
            {
                for(int j=1;j<=11;++j)
                {
                    int tem=-1;
                    tem=tem>set[i+1][j-1]?tem:set[i+1][j-1];
                    tem=tem>set[i+1][j]?tem:set[i+1][j];
                    tem=tem>set[i+1][j+1]?tem:set[i+1][j+1];

                    set[i][j]+=tem;
                }
            }

            System.out.println(set[0][6]);
        }
    }
}
