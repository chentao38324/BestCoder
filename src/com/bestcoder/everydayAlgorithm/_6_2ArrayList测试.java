package com.bestcoder.everydayAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chentao on 16-8-3.
 * ArrayList的clear() 会影响到之前添加过得 引用 想不影响到之前的可以
 */
public class _6_2ArrayList测试 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<List<Integer>> listList = new ArrayList<>();

        intList.add(0,1);
        intList.add(1,2);
        intList.add(2,3);
        listList.add(0,intList);
        intList = new ArrayList<>();
        intList.add(0,4);
        intList.add(1,5);
        intList.add(2,6);
        listList.add(1,intList);


    }
}
