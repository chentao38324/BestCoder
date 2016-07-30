package com.bestcoder.kmp;

/**
 * Created by chentao on 16-7-29.
 */
public class KmpTest {
    private int[] getNext(String pattern) {
        int len = pattern.length();
        if (len == 1){
            return new int[] {-1};
        }
        int j = 0;
        int k = -1;
        int[] next = new int[len];
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    private int kmp(String s,String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();
        int[] next = getNext(pattern);

        while (i<slen && j<plen) {
            if (s.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                }else {
                    j = next[j];
                }
            }
            if (j == plen) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        KmpTest kmpTest = new KmpTest();
        String str = "bbc abcdab abcdabddabcdabd";
        String pattern = "abcdabd";
        System.out.println(kmpTest.kmp(str,pattern));
    }
}
