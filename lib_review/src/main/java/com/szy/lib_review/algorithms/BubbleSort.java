package com.szy.lib_review.algorithms;

/**
 * Name: BubbleSort
 * Author: YJQ
 * Date: 2020/4/23
 * Desc:
 */
public class BubbleSort {


//API: 冒泡排序【时间复杂度 O(n^2)  空间复杂度：O(1)  稳定排序  原地排序】
//     1.把第一个元素跟第二个元素比较，如果第一个比第二个大，则交换他们的位置，接着比较第二个元素与第三个元素，如果第二个比第三个大，则交换。。。依次类推
//     2.一趟下来，最小或最大的元素就在最右边；
//     3.除去最右的元素，我们对剩余的元素做同样的工作，如此重复，直到排序完成
//     NOTE:优化：假如从开始的第一对到结尾的最后一对，相邻的元素之间都没有发生交换的操作，这意味着右边的元素总是大于等于左边的元素，
//     此时的数组已经是有序的了，我们无需再对剩余的元素重复比较下去了。
//     比较次数：1 + 2 + 3 .... n


    /**
     * 冒泡排序 官方模板实现
     */
    public static void officialBubbleSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    flag = false;
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
            //一趟下来是否发生位置交换
            if (flag)
                break;
        }
        AlgorithmUtil.print(a);
    }


    /**
     * 冒泡排序 纯个人实现
     */
    private static void myBubbleSort(int[] a) {
        int n = a.length;

        //外层循环仅仅是表示第i趟的找出最值放在右边，减去1是因为最后一趟其它元素的位置都确定了，无需继续排了
        for (int i = 0; i < n - 1; i++) {        //每一轮排序确定一个元素的位置，那么长度为n的数组只需要排n-1趟

            boolean swap = false;
            // 留意 n-i ,每排一次，倒数多一个元素不用参与排序
            // 即 第i趟参与排序的元素为a[0].a[1]..a[2]..a[n-i-1],注意这里的i 是外层的i，当i=0时，实际上是第一趟
            for (int j = 0; j + 1 < n - i; j++) {   //NOTE: n-i 是因为 外层循环i 的范围是[0,n-1) ,每排一趟，右边就少一个需要参与排序的元素，第i趟 < n -i 合理
                if (a[j] > a[j + 1]) {              // 这个时候我们要考虑内部循环体我们使用哪种方式表达两个相邻的元素，而不是先确立j的范围再写循环体内部的逻辑
                    int temp = a[j];                //     情况1： 循环体内部使用        a[j]   和  a[j+1]         表示两个相邻的元素
                    a[j] = a[j + 1];                //            为了防止数组越界，  0<= j     <    j+1    < n    则 for(int j=0;j+1<n-i;j++)
                    a[j + 1] = temp;                //     情况2：循环体内部使用       a[j-1]  和   a[j]           表示两个相邻的元素
                    swap = true;                    //            为了防止数组越界，  0<j-1    <     j     <  n    则 for(int j=1;j<n-i;j++)
                }
            }

            //一趟下来是否发生位置变化，如果没有则表明:每个数都比左边的大，比左边的小,这就是有序
            if (!swap) break;
            AlgorithmUtil.print(a);
        }

    }


    /**
     * 冒泡排序 测试用
     */
    public static void testBubbleSort(int[] a) {

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j + 1 < n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swap = true;
                }

            }

            if (!swap)
                break;
            AlgorithmUtil.print(a);
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 1, 3, 4, 0, 7, 6, 8, 2};
        AlgorithmUtil.print(array);

        //myBubbleSort(array);
        //officialBubbleSort(array);
        //testBubbleSort(array);
    }
}
