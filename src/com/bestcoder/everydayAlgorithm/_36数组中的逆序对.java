package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-10.
 * 题目：在数组中两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 *      输入一个数组，求出逆序对总数 例如{7,5,6,4}中有5个逆序对(7,6),(7,5),(7,4),(6,4),(5,4)
 * 第一反应：顺序扫描整个数组，比较该数字和他后面数字的大小，比他小就组成逆序对，由于每个数字都要和O（n）个数字比较所以O（n²）
 *
 * 思路：不和后面每一个数字比较，先比较两个相邻的，
 *      先类似归并排序，把数字分成两份，继续分到只剩一个然后合并两个长度为1的子数组并排序，统计逆序对，合并完长度为1的再合并长度为2的
 *      分成的两部分，用两个指针指i，j向两部分的最后一个元素，如果i>j逆序对有第二个数组长度的个数，并把i放入辅助数组i指针前移，辅助数组指针前移
 *      若<则无逆序对 j和辅助数组指针前移
 *      归并O(nlogn) 空间O(n)
 */
public class _36数组中的逆序对 {
    public static void main(String[] args){
        int[] array = {7,5,6,4};
        System.out.println(inversePairs(array));
    }

    public static int inversePairs(int[] data){
        if (data == null || data.length < 1)
            return 0;
        int len = data.length;
        int[] copy = new int[len];
//        System.arraycopy(data, 0, copy, 0, data.length);    //此处是将data数组中的值复制到copy数组中都从0位置开始，复制个数为长度，其实没必要，后面copy数组会自动填满
        int count = inversePairsCore(data,copy,0,len-1);
        return count;
    }

    private static int inversePairsCore(int[] data1, int[] copy1, int start, int end) {
        if (start == end){      //递归结束的标志，分成最后两份中只有一个元素
            copy1[start] = data1[start];
            return 0;
        }

        int mid = (start + end)/2;      //继续分
        int left = inversePairsCore(copy1,data1,start,mid);     //1.这里注意啦  copy和data顺序要反过来
        int right = inversePairsCore(copy1,data1,mid+1,end);

        int i = mid; //前半部分最后元素的指针
        int j = end; //后半部。。
        int index = end; //辅助数组最后指针
        int count = 0;
        while (i >= start && j>= mid+1){
            if (data1[i] > data1[j]){                           //在上面1处，因为copy和data顺序是反的，所以其实改变的是data，跳出来后就比较data
                copy1[index--] = data1[i--];
                count += j - mid;
            }else {
                copy1[index--] = data1[j--];
            }
        }
        while (i>=start){
            copy1[index--] = data1[i--];
        }
        while (j>=mid+1){
            copy1[index--] = data1[j--];
        }
        return left+right+count;
    }
}
