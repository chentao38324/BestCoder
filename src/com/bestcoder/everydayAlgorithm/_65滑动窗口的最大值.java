package com.bestcoder.everydayAlgorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chentao on 16-8-14.
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *      eg.输入数组{2,3,4,2,6,2,5,1} 以及滑动窗口大小3，
 *         那么一共存在6个滑动窗口，它们的最大值分别为{4,4,6,6,6,5}
 *
 * 一般思路：蛮力法：滑动窗口长度为k，要O（k）找到最大值，数组长度为n，总共O（nk）
 *
 *         升级：滑动窗口可以看做队列，窗口滑动时，处于窗口的第一个数字被删除，同时在末尾添加一个新的数字
 *         如果能从队列找到最大值 就解决问题
 *         之前实现过用O(1)时间找到最小值的栈（21题），那么也可以找到最大值
 *         实现过两个栈实现队列，（7题） 结合以下
 *
 * 最终：下面换一种思路。我们并不把滑动窗口的每个数值都存入队列中，而只把有可能成为滑动窗口最大值的数值存入到
 * 一个两端开口的队列。接着以输入数字{2,3,4,2,6,2,5,1}为例一步分析。数组的第一个数字是2，把它存入队列中。
 * 第二个数字是3.由于它比前一个数字2大，因此2不可能成为滑动窗口中的最大值。2先从队列里删除，再把3存入到队列中。
 * 此时队列中只有一个数字3.针对第三个数字4的步骤类似，最终在队列中只剩下一个数字4.此时滑动窗口中已经有3个数字，
 * 而它的最大值4位于队列的头部。接下来处理第四个数字2。2比队列中的数字4小。当4滑出窗口之后2还是有可能成为滑动
 * 窗口的最大值，因此把2存入队列的尾部。现在队列中有两个数字4和2，其中最大值4仍然位于队列的头部。
 * 下一个数字是6.由于它比队列中已有的数字4和2都大，因此这时4和2已经不可能成为滑动窗口中的最大值。先把4和2从队列中删除，
 * 再把数字6存入队列。这个时候最大值6仍然位于队列的头部。第六个数字是2.由于它比队列中已有的数字6小，所以2也存入队列的尾部。
 * 此时队列中有两个数字，其中最大值6位于队列的头部。接下来的数字是5.在队列中已有的两个数字6和2里，2小于5，
 * 因此2不可能是一个滑动窗口的最大值，可以把它从队列的尾部删除。删除数字2之后，再把数字5存入队列。此时队列里剩下
 * 两个数字6和5，其中位于队列头部的是最大值6.数组最后一个数字是1，把1存入队列的尾部。注意到位于队列头部的数字6
 * 是数组的第5个数字，此时的滑动窗口已经不包括这个数字了，因此应该把数字6从队列删除。那么怎么知道滑动窗口是否包
 * 括一个数字？应该在队列里存入数字在数组里的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于或者
 * 等于滑动窗口的大小时，这个数字已经从滑动窗口中滑出，可以从队列中删除了。
 *
 * 两端开口的队列Deque  java.util.Deque
 */
public class _65滑动窗口的最大值 {

    public static void main(String[] args){
        int[] data = {2,3,4,2,6,2,5,1};
        System.out.println(data+"中大小为3的滑动窗口的最大值："+maxInWindow(data,3));
    }

    public static List<Integer> maxInWindow(int[] data,int size){
        if (data == null || data.length < 1 || size < 1)
            return null;
        List<Integer> windowMax = new LinkedList<>();
        Deque<Integer> idx = new LinkedList<>();

        //构建一开始的滑动窗口 元素还没倒size个  窗口还没有被填满时，找最大值的索引
        //这个循环都是加队尾？
        for (int i = 0; i < size && i < data.length; i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data[i] >= data[idx.getLast()]){
                idx.removeLast();
            }
            idx.addLast(i);
        }
        //窗口已经被填满了
        for (int i = size; i < data.length; i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data[idx.getFirst()]);
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data[i] >= data[idx.getLast()]){
                idx.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i-size)){
                idx.removeFirst();
            }
            // 可能的最大的下标索引入队
            idx.addLast(i);
        }
        // 最后一个窗口最大值入队
        windowMax.add(data[idx.getFirst()]);
        return windowMax;
    }
}
