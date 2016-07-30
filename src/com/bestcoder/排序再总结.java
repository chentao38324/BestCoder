package com.bestcoder;


/**
 * Created by chentao on 16-4-12.
 * 再次总结常用的八大排序，忘记时看下  核心代码  ，瞬间想起。
 */
public class 排序再总结 {
    public static final int[] data = {9,6,2,7,8,3};
    public static void main(String[] args){
        radixSort(data);
        for (int i : data) {
            System.out.println(i);
        }
    }



    /**
     * 传统冒泡排序
     */
    private static void bubble(int[] data) {
        int size = data.length;//原始数组大小
        int tem; //临时变量
        for (int i = size-1;i>0;i--) {
            for (int j = 0;j<i;j++) {
                //比较相邻两数，若第一数较大则交换
                if (data[j] > data[j+1]) {
                    tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                }
            }
        }
    }

    /**
     * 改进的冒泡排序，如果一次比较后没有交换 证明已排好序，直接跳出循环
     */
    private static void improvedbubble(int[] data) {
        int tem;  //临时变量
        int flag;  //判断是否有执行交换的动作
        int size = data.length;//原始数组大小
        for (int i = size-1;i>0;i--) {
            flag = 0;
            for (int j = 0;j<i;j++) {
                //比较相邻两数，若第一数较大则交换
                if (data[j] > data[j+1]) {
                    tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                    flag++; //执行过交换 flag不为0
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * 例如N个数据要由大到小排序时，首先以第一个位置的数据，
     * 依次向2,3,4，N个位置的数据作比较，
     * 如果数据大于或等于其中一个位置，则两个位置的数据不变，
     * 若小于，则交换
     */
    private static void selectionSort (int[] data){
        int tem;  //临时变量
        int size = data.length;//原始数组大小
        for (int i = 0;i<size-1;i++) { //扫描size-1次
            for (int j = i+1;j<size;j++) {//由i+1比较，比较size-1次
                if (data[i] > data[j]) {//比较第i及第j份元素
                    tem = data[i];
                    data[i] = data[j];
                    data[j] = tem;
                }
            }
        }
    }

    /**
     * 插入排序
     * 是将数组中的元素，逐一与已排序好的数据作比较，
     * 再将该数组元素插入适当的位置。
     */
    private static void insertSort(int[] data) {
        int tem;  //临时变量
        int size = data.length;//原始数组大小
        int j;//定位比较的元素
        for (int i =1;i<size;i++) {//默认第一个元素已排好序，从第二个元素开始扫描，扫描size-1次
            tem = data[i];
            j = i-1; //将data[i] 与 它的前一位data[i-1] 比较
            while (j>=0 && tem<data[j]) { //若小于
                data[j+1] = data[j]; //就把所有的元素往后推一个
                j--;
            }
            data[j+1] = tem; //最小的元素 放到移动后的缺口处
        }
    }

    /**
     * 希尔排序
     * D.L.Shell 在 1959年7月发明的一种排序
     * 时间复杂度达到O(n^1.5)
     * 有点像插入排序，将数据区分成特定间隔的几个小块，以插入排序法排完
     * 区块内的数据后再渐渐减少间隔距离
     */
    private static void shellSort(int[] data){
        int tem;  //临时变量
        int jmp;  //设定间隔位移量
        int size = data.length;//原始数组大小
        int j;//定位比较的元素
        jmp = size/2; //先以数组大小的一半作为间隔位移量
        while (jmp != 0) {
            for (int i = jmp;i<size;i++) {
                tem = data[i];
                j = i - jmp;
                //下面就是插入排序了
                while (j>=0 && tem < data[j]) {
                    data[j+jmp] = data[j];
                    j = j - jmp;
                }
                data[jmp + j] = tem;
            }
            jmp = jmp/2;  //控制循环数
        }
    }

    /**
     * 快速排序
     * 假设有n个记录R1,R2,R3...Rn,键值为k1,k2,k3...kn
     * 1.取k为第一个键值
     * 2.由左向右找出一个键值Ki 使得Ki>K
     * 3.由右向左找出一个键值Kj 使得Kj<K
     * 4.若i<j 则Ki与Kj交换，并继续步骤2
     * 5.若i>=j 则将K与Kj交换，并以j为记住将数据分为左右两部分，
     * 以递归方式分别对左右两边进行排序，直至完成排序
     */
    private static void quickSort2(int[] data,int left,int right) {
        int tem;//临时变量
        int lf_idx;//从左向右移动的键
        int rg_idx;//从右向左移动的键
        //第一个键值为data[left]
        if (left < right) {
            lf_idx = left+1;
            rg_idx = right;
            //开始排序
            while (true) {
                for (int i = left+1;i<=right;i++) {//2.由左向右找出一个键值>data[left]者
                    if (data[i] >= data[left]) {
                        lf_idx = i;
                        break;
                    }
                    lf_idx++;
                }
                for (int j = right;j>=left+1;j--) {//3.由右向左找出一个键值<data[left]者
                    if (data[j] <= data[left]) {
                        rg_idx = j;
                        break;
                    }
                    rg_idx--;
                }
                if (lf_idx < rg_idx) {//4.若lf_idx < rg_idx
                    tem = data[lf_idx]; //则交换data[lf_idx]和data[rg_idx]
                    data[lf_idx] = data[rg_idx];
                    data[rg_idx] = tem;
                }else {
                    break;
                }
            }
            //整理
            if (lf_idx >= rg_idx) {  //5-1 若lf_idx >= rg_idx
                tem = data[left]; //则交换 data[left] 和 data[rg_idx]
                data[left] = data[rg_idx];
                data[rg_idx] = tem;
                //5-2 并以rg_idx为基准点分成两半，递归排序
                quickSort2(data,left,rg_idx-1);
                quickSort2(data,rg_idx+1,right);
            }
        }
    }

    /**
     * 堆排序
     * http://www.cnblogs.com/ttltry-air/archive/2012/08/03/2621962.html
     *1.建初始堆：将R[1..n]构造为初始堆；
     *2.堆调整：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆。
     */
    public static void buildHeap(int a[]) {
        int heapSize = a.length;
        int filter = heapSize / 2;
        // i从第一个非叶子结点开始
        for (int i = filter - 1; i >= 0; i--) {
            heapAdjust(a, i, heapSize);
        }
    }

    // 已知H.r[i...heapSize]中记录的关键字除H.r[i]外，均满足最大堆结构
    public static void heapAdjust(int arr[], int i, int heapSize) {
        // 当前待调整的元素
        int tmp = arr[i];
        // 该元素的左孩子
        int index = 2 * i + 1;
        while (index < heapSize) {
            // 如果右孩子大于左孩子,则index+1，即交换右孩子和双亲节点
            if (index + 1 < heapSize && arr[index] < arr[index + 1]) {
                index = index + 1;
            }
            if (arr[i] < arr[index]) {
                arr[i] = arr[index];// 交换孩子和双亲节点
                i = index;// 重新赋初值
                index = 2 * i + 1;
            }
            else {
                break;// 已经是最大堆
            }
            arr[i] = tmp;// 把双亲值赋给孩子节点
        }
    }

    public static void heapSort(int a[]) {
        int heapSize = a.length;
        for (int i = heapSize - 1; i > 0; i--) {
            // 交换堆顶和最后一个元素
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 在heapSize范围内根结点的左右子树都已经是最大堆,所以只需看新交换的堆顶元素是否满足最大堆结构即可。
            // 将H.r[0...i]重新调整为最大堆
            heapAdjust(a, 0, i);
        }
    }

    /**
     * 归并排序
     * https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F#Java
     */
    public static int[] merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        for(block = 1; block < len ; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
        return result;
    }

    /**
     * 基数排序
     * 假设每个数位数不超过3位
     */
    private static void radixSort(int[] data) {
        int size = data.length;
        int k;
        int n;
        int m;
        for (n = 1;n<=100;n = n*10) { //n为基数 从个位开始排序
            //设定暂存数组，[0~9位数][数据个数]，所有内容均为0
            int[][] tem = new int[10][100];
            for (int i=0;i<size;i++) {   //比较所有数据
                m = (data[i]/n)%10;   //m为n位数的值
                tem[m][i] = data[i]; //把data[i]的值暂存在tem里
            }
            k=0;
            for (int i =0;i<10;i++) {
                for (int j=0;j<size;j++) {
                    if (tem[i][j] != 0) {  //一开始设定tem={0}，所以不为0证明里面有数
                        //把data暂存在tem里的值 放回data[]里
                        data[k] = tem[i][j];
                        k++;
                    }
                }
            }
        }
    }

}
