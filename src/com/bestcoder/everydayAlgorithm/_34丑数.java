package com.bestcoder.everydayAlgorithm;

/**
 * Created by chentao on 16-8-10.
 * 题目：我们把只包含因子2、3 和5 的数称作丑数（Ugly Number）。求从小到大的顺序的第1500个丑数。
 *      例如6、8 都是丑数，但14 不是，它包含因子7。习惯上我们把1 当做第一个丑数。
 *
 * 方法一：直观但不高效 逐个判断
 *
 * 方法二：创建数组保存已找到的丑数，用空间换时间
 *      上面方法效率低，不管一个数是不是丑数，都要计算
 *      这种方法只用计算丑数，不在非丑数上花费时间。
 *      丑数应该是另一个丑数上×2或×3或×5（1除外）。
 *      因此创建一个数组存放排好序的丑数，每一个丑数都是前面的丑数×2.3.5得到的
 *      把前面每一个丑数分别乘以2,3,5分别得到一个大于已有丑数中最大数M 的M2,M3,M5,其实没必要这样，
 *      前面肯定存在一个丑数T2，他之前的丑数×2<M，它之后每一个丑数×2会大于M。记下这个T2位置，每次生成新的丑数
 *      更新T2，同样存在T3，T5
 */
public class _34丑数 {
    public static void main(String[] args){
        int index = 2500;
//        System.out.println("第" + index + "个丑数为：" + getUglyNumber(index));
        System.out.println("第" + index + "个丑数为：" + getUglyNumber2(index));
    }

    //方法一
    public static int getUglyNumber(int index){
        if (index <= 0)
            return 0;
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index){
            number++;
            if (isUgly(number)){
                uglyFound++;
            }
        }
        return number;
    }

    private static boolean isUgly(int number) {
        while (number%2 == 0)
            number /= 2;
        while (number%3 == 0)
            number /= 3;
        while (number%5 == 0)
            number /= 5;
        return number == 1;
    }

    //方法二
    public static long  getUglyNumber2(int index){
        if (index <= 0)
            return 0;
        long[] tem = new long[index];//保存已找到的丑数
        tem[0] = 1;//第一个丑数是1
        int nextUglyIdex = 1; //下一个丑数的下标

        int multi2 = 0;
        int multi3 = 0;
        int multi5 = 0;

        long curUglyNum;
        while (nextUglyIdex < index){
            curUglyNum = min(tem[multi2]*2,tem[multi3]*3,tem[multi5]*5);
            tem[nextUglyIdex] = curUglyNum;
            while (tem[multi2]*2 <= curUglyNum) {
                multi2++;
            }
            while (tem[multi3]*3 <= curUglyNum) {
                multi3++;
            }
            while (tem[multi5]*5 <= curUglyNum) {
                multi5++;
            }
            nextUglyIdex++;
        }
        return tem[nextUglyIdex-1];
    }

    private static long min(long num1, long num2, long num3) {
        long min = (num1<num2) ? num1 : num2;
        return (min < num3) ? min : num3;
    }
}
