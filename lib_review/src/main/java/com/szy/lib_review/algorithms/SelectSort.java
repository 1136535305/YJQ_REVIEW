package com.szy.lib_review.algorithms;

/**
 * Name: SelectSort
 * Author: YJQ
 * Date: 2020/4/23
 * Desc:
 */
public class SelectSort {
    //API： 选择排序 【时间复杂度 O(n^2)  空间复杂夫O(1)  非稳定排序  原地排序】
    //     首先，找到数组中最小的那个元素，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
    //     其次，在剩下的元素中找到最小的元素，将它于数组中的第二个元素交换位置，如此往返，知道整个数组排序。
    //     比较次数：n + (n-1) + (n-2) +  ....1

    /**
     * 选择排序 官方模板
     */
    private static void officialSelectSort(int[] a) {


        //第i次定位， 从a[i]  ..a[i+1] ..a[n-1]中，找出最小值放到a[i]  上，
        //然后下次    从a[i+1]..a[i+2] ..a[n-1]中，找出最小值放到a[i+1]上
        //直到a[i] 为   a[n-1]（最后一个元素）时，因为一个元素肯定是最小的了，不用比较了
        //所以最后一次定位可以省略

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {           //这个 n-1 是因为最后一次不用比较了，当你已经找出a[n-2]的应该存放的元素时，a[n-1]的位置也已经确定了
            int min = i;                            //第i次定位，如果a[i]已经是最小值，那么a[i]与a[i]交换，


            for (int j = i + 1; j < n; j++) {       //第一步：内层循环每次找出最小值，并且内层循环会自动往右移
                if (a[min] > a[j])                  //第一次内循环的时候，a[min]是a[i]
                    min = j;                        //min记录当前最小值下标，a[min]为当前最小值，a[j]指向遍历元素
            }
            //交换
            int temp = a[i];                        //来到这里，a[min]为第i次找出最小元素时，当前数组  a[i]  右边所有元素的最小值
            a[i] = a[min];                          //那么我们就要把a[min]放在a[i]上
            a[min] = temp;                          //这个位置上，完成第i次的最小元素的定位
        }
        AlgorithmUtil.print(a);
    }


    /**
     * 选择排序 纯个人实现
     */
    private static void mySelectSort(int[] a) {

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) min = j;
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        AlgorithmUtil.print(a);
    }


    /**
     * 选择排序 测试用
     */
    private static void testSelectSort(int[] a) {

        int n = a.length;

        for (int i = 0; i < n - 1; i++) {

            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            AlgorithmUtil.print(a);
        }
    }
}
