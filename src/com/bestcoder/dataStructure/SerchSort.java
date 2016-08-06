package com.bestcoder.dataStructure;

/**
 * Created by chentao on 16-8-4.
 * 排序与查找
 */
public class SerchSort {

    public static void main(String[] args){
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = i+1;
        }
        SerchSort serchSort = new SerchSort();
        //二分查找
        int result = serchSort.binSerch(data,2);
        //插值查找
        int result2 = serchSort.insertSerch(data,2);

        int[] arry = { 6, 2, 4, 1, 5, 9,45,65,345,234,445,323,789,45,343,454,555,556,335 };
//        serchSort.bubleSort(arry);
//        showData(arry,"冒泡排序:");
//        serchSort.bubuleSort2(arry);
//        showData(arry,"改进的冒泡排序:");
//        serchSort.selectionSort(arry);
//        showData(arry,"选择排序:");
//        serchSort.insertSort(arry);
//        showData(arry,"插入排序:");
//        serchSort.shellSort(arry);
//        showData(arry,"希尔排序:");
        serchSort.quickSort(arry);
        showData(arry,"快速排序:");
//        serchSort.heapSort(arry);
//        showData(arry,"堆排序:");
//        serchSort.mergeSort(arry);
//        showData(arry,"归并排序:");
//        serchSort.radixSort(arry);
//        showData(arry,"基数排序:");

    }

    private static void showData(int[] data,String str) {
        System.out.print("\n"+str);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }

    /**查找算法*/

    /**
     * 二分查找
     * 数据必须排序好
     * 时间复杂度 Ｏ(logn)
     * @param data 数组
     * @param val 要查找的值
     * @return 索引 返回－１未找到
     */
    private int binSerch(int[] data,int val){
        int low = 0;
        int high = data.length -1;
        int mid;
        int compareTimes = 0;
        while (low<=high){
            compareTimes++;
            mid = (low+high)/2;
            if (val == data[mid]){
                System.out.println("二分查找比较次数："+compareTimes);
                return mid;
            }else if (val<data[mid]){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 插值查找
     * 数据必须排序好 数据分布均匀
     * 优于Ｏ(logn)
     * @param data 数组
     * @param val 要查找的值
     * @return 键 返回－１未找到
     */
    private int insertSerch(int[] data,int val){
        int low = 0;
        int high = data.length -1;
        int mid;
        int compareTimes = 0;
        while (low<=high){
            compareTimes++;
            //对比二分查找只是改变了mid 的计算公式
            mid = low+(high-low)*(val-data[low])/(data[high]-data[low]);
            if (val == data[mid]){
                System.out.println("插值查找比较次数："+compareTimes);
                return mid;
            }else if (val<data[mid]){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 建立哈希表子程序
     * @param val
     */
    private Node[] indextable = new Node[10];   //声明动态数组
    public void creatHashTable(int val){
        Node newNode = new Node(val);
        int hash = val%7;   //哈希函数除以7取余数
        Node currentNode = indextable[hash];
        if (currentNode.next == null){
            indextable[hash].next = newNode;
        }else {
            while (currentNode.next != null) currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
    /**
     * 哈希查找子程序
     * 常见的哈希法：除留余数法，平方取中法，折叠法，数字分析法。
     * 常见的溢出处理方法：线性探测发，平方探测，再哈希，链表。
     * @param val
     * @return
     */
    public int hashSerch(int val){
        Node ptr;
        int i = 0; //查找次数（找到）
        int hash = val % 7;
        ptr = indextable[hash].next;
        while (ptr != null){
            i++;
            if (ptr.val == val){
                return i;
            }else {
                ptr = ptr.next;
            }
        }
        return 0;   //没找到
    }

    /**
     * 链表节点
     */
    class Node {
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

                                /**排序算法*/
    /**
     * 冒泡排序
     *
     * 适合 数据量小 部分已排序
     * 时间复杂度 O(n²)
      * @param data
     */
    public void bubleSort(int[] data){
        int len = data.length;
        int tem;
        for (int i = len -1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                //比较相邻两数，若第一数较大则交换
                if (data[j] > data[j+1]){
                    tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                }
            }
        }
    }

    /**
     * 改造后的冒泡排序
     * @param data
     */
    public void bubuleSort2(int[] data){
        int len = data.length;
        int tem;
        int flag;
        for (int i = len-1;i>0;i--){
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j+1]){
                    tem = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tem;
                    flag++;
                }
            }
            if (flag == 0){
                break;
            }
        }
    }

    /**
     * 选择排序
     * 例如N个数据要由小到大排序时，首先以第一个位置的数据，
     * 依次向2,3,4，N个位置的数据作比较，
     * 如果数据小于或等于其中一个位置，则两个位置的数据不变，
     * 若大于，则交换
     *
     * 适合：大部分已排序
     * 时间复杂度 O(n²) 好差都是
     * @param data
     */
    public void selectionSort(int[] data){
        int len = data.length;
        int tem;
        for (int i = 0; i < len - 1; i++) { //扫描len-1次
            for (int j = i + 1; j < len; j++) {//从i+1开始比较
                if (data[i] >= data[j]){
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
     *
     * 适合：大部分已排序
     * 时间复杂度 O(n²) 最好：O(n)
     * @param data
     */
    public void insertSort(int[] data){
        int len = data.length;
        int tem;
        int j;  //定位比较的元素
        for (int i = 1; i < len; i++) {//默认第一个元素已排好序，从第二个元素开始扫描，扫描len-1次
            j = i-1;    //将data[i] 与 它的前一位data[i-1] 比较
            tem = data[i];
            while (j >= 0 && tem < data[j]){
                data[j+1] = data[j];    //若tem比自己前面的元素小，前面的元素就往后移 循环
                j--;
            }
            data[j+1] = tem;    //最小的元素 放到移动后的缺口处
        }
    }

    /**
     * 希尔排序 像插入
     * 有点像插入排序，将数据区分成特定间隔的几个小块，以插入排序法排完
     * 区块内的数据后再渐渐减少间隔距离
     *
     * 时间复杂度达到O(n^1.3)
     * @param data
     */
    public void shellSort(int[] data){
        int len = data.length;
        int tem;
        int j;              //定位比较元素
        int jmp = len/2;    //间隔量
        while (jmp != 0){
            //下面就是插入排序
            for (int i = jmp; i < len; i++) {
                tem = data[i];
                j = i - jmp;
                while (j >= 0 && tem < data[j]){
                    data[j+jmp] = data[j];
                    j -= jmp;
                }
                data[j+jmp] = tem;
            }
            jmp = jmp/2;
        }
    }

    /**
     * 快速排序  -  基于交换
     * 假设有n个记录R1,R2,R3...Rn,键值为k1,k2,k3...kn
     * 1.取k为第一个键值
     * 2.由左向右找出一个键值Ki 使得Ki>K
     * 3.由右向左找出一个键值Kj 使得Kj<K
     * 4.若i<j 则Ki与Kj交换，并继续步骤2
     * 5.若i>=j 则将K与Kj交换，并以j为基准 将数据分为左右两部分，
     * 以递归方式分别对左右两边进行排序，直至完成排序
     *
     * 时间复杂度 最好和平均为O(nlogn) 最坏O(n²)-每次选的中间值为最大或最小
     * 空间复杂度 O(logn)
     * 快排的实现是递归调用的， 而且每次函数调用中只使用了常数的空间，因此空间复杂度等于递归深度logn
     * @param data 数组
     */

    public void quickSort(int[] data){
        quickSort(data,0,data.length-1);
    }

    /**
     * 快速排序
     * @param data 数组
     * @param left  左边界
     * @param right 右边界
     */
    public void quickSort(int[] data,int left,int right){
        int tem;
        int l;              //从左往右移动的键
        int r;              //从右往左移动的键
        if (left<right) {
            l = left + 1;
            r = right;
            //开始比较 把比第一个大的放右边 小的放左边
            while (true) {
                for (int i = l; i <= r; i++) {  //2.由左向右找出一个键值>data[left]者
                    if (data[i] > data[left]) {
                        l = i;
                        break;
                    }
                    l++;
                }
                for (int i = r; i >= l; i--) {  //3.由右向左找出一个键值<data[left]者
                    if (data[i] < data[left]) {
                        r = i;
                        break;
                    }
                    r--;
                }
                if (l < r) {   //4.l<r 交换
                    tem = data[l];
                    data[l] = data[r];
                    data[r] = tem;
                } else {
                    break;
                }
            }
            //整理
            if (l >= r) {  //5-1 若l >= r
                tem = data[left];   //则交换 data[left] 和 data[r]
                data[left] = data[r];
                data[r] = tem;          //这个r可以利用好，左边是小于它右边是大于，data[r]是第r大的数
                //5-2 并以r为基准点分成两半，递归排序
                quickSort(data, left, r - 1);
                quickSort(data, r + 1, right);
            }
        }
    }

    /**
     * 堆排序  -  选择排序的改进版
     * http://www.cnblogs.com/ttltry-air/archive/2012/08/03/2621962.html
     *1.建初始堆：将R[1..n]构造为初始堆；
     *2.堆调整：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆。
     *
     * 时间复杂度 所有情况 O(nlogn)
     * @param data
     */
    public void heapSort(int[] data){
        int heapSize = data.length;
        int nonLeaf = heapSize/2; //第一个非叶子节点
        int tem;
        //初始建最大堆
        for (int i = nonLeaf - 1; i >= 0 ; i--){
            heapAdjust(data,i,heapSize);
        }

        //堆排序
        for (int i = heapSize-1;i>0;i--){
            //交换首尾元素
            tem = data[0];
            data[0] = data[i];
            data[i] = tem;
            //此时，R[0...i-1]中，除了0之外 都是最大堆，所以只需将第0个元素再构建一次最大堆即可
            heapAdjust(data,0,i);//这里的第三个参数i 是指要构建最大堆的数组的大小，所以传i，只会构建到i-1
        }

    }

    /**
     * 从第i个元素开始 往下构建最大堆
     * @param data 数组
     * @param i 这个元素之下会比较 1 遍
     * @param heapSize 数组大小 比最后一个元素索引 大1
     */
    private void heapAdjust(int[] data, int i, int heapSize) {
        int tem = data[i];
        int index = 2*i+1;  //i节点的左孩子
        while (index < heapSize){
            //如果存在右孩子且右孩子大于左孩子
            if (index+1<heapSize && data[index] < data[index+1]){
                index++;
            }
            //若果i节点比孩子小 交换 重新赋值
            if (data[i] < data[index]){
                data[i] = data[index];
                i = index;
                index = index*2+1;
            }else {//i节点大 跳出
                break;
            }
            data[i] = tem;
        }
    }

    /**
     * 归并排序
     * 思路：将数组分成二组A，B，如果这二组组内的数据都是有序的，那么就可以很方便的将这二组数据进行排序。
     * 如何让这二组组内数据有序了？
     * 可以将A，B组各自再分成二组。依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，
     * 然后再合并相邻的二个小组就可以了。这样通过先递归的分解数列，再合并数列就完成了归并排序。
     *
     * 时间复杂度 都为O(nlogn)
     * 空间复杂度 O(n)
     */
    public void mergeSort(int[] data){
        int[] tem = new int[data.length];
        mergeSort(data,0,data.length-1,tem);
    }

    /**
     * 递归分开合并
     * @param unsorted 未排序数组
     * @param first 数组第一个索引
     * @param last  数组的最后一个索引
     * @param sorted    辅助空间 放已排序数组
     */
    public void mergeSort(int[] unsorted,int first,int last,int[] sorted){
        if (first < last){
            int mid = (first+last)/2;
            mergeSort(unsorted,first,mid,sorted);   //排序左边
            mergeSort(unsorted,mid+1,last,sorted);  //排序右边
            mergeArray(unsorted,first,mid,last,sorted); //合并两个数组
        }
    }

    /**
     * 两个有序数组合并
     * @param unsorted 未排序数组
     * @param first 数组第一个索引
     * @param mid 数组中间索引
     * @param last 数组的最后一个索引
     * @param sorted 辅助空间 放已排序数组
     */
    private void mergeArray(int[] unsorted, int first, int mid, int last, int[] sorted) {
        int i = first;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<=last){
            if (unsorted[i] < unsorted[j]){
                sorted[k++] = unsorted[i++];
            }else {
                sorted[k++] = unsorted[j++];
            }
        }
        while (i <= mid){
            sorted[k++] = unsorted[i++];
        }
        while (j <= last){
            sorted[k++] = unsorted[j++];
        }
        for (int l = 0; l < k; l++) {
            unsorted[first+l] = sorted[l];
        }
    }

    /**
     * 基数排序
     * 这里是最低位优先，按个位十位百位来比较，
     * 1.把每个整数按照其个位数字放到表中，
     * 2.合并
     * 3.循环,再按照十位数字，百位数字
     *
     * 时间复杂度 O(nlogpK)
     * 空间复杂度O(n*p)
     * p是基数 100基数为3 k是原始数据最大值
     * @param data
     */
    public void radixSort(int[] data){
        int len = data.length;
        int n;  //数的哪一位 个位  十位等
        int m;  //每个块的标号 0-9
        int k;  //每次将临时数组放回原数组 的索引
        for ( n = 1; n <= 100 ; n*=10) {    //n为基数 从个位开始排序 100代表数字都为3位数 数组中最大数字的位数
            //设定暂存数组，[0~9位数][数据个数]，所有内容均为0
            int[][] tem = new int[10][len];
            for (int i = 0; i < len; i++) {
                m = (data[i]/n)%10;     //m为n位数的值
                tem[m][i] = data[i];    //把data[i]的值暂存在tem里
            }
            //遍历临时数组中的值放回原数组
            k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < len; j++) {
                    if (tem[i][j] != 0){
                        data[k++] = tem[i][j];
                    }
                }
            }
        }
    }

}