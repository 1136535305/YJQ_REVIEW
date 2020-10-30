package com.szy.lib_review.algorithms;

/**
 * Name: InsertSort
 * Author: YJQ
 * Date: 2020/4/23
 * Desc:
 */
public class InsertSort {


    //API: 插入排序 【把一张牌插入已经有序的牌里】   【时间复杂度 O(n^2)  空间复杂夫O(1)  稳定排序  原地排序】
    //      1.从数组第2个元素开始抽取元素；
    //      2.把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去，直到遇到不比它大的元素，然后插到这个元素的右边。
    //      3.继续选取第3，4，5，。。。n个元素，重复上面的步骤，选择合适的位置插入
    //      比较次数：1 + 2 + 3 .... n

    /**
     * 插入排序 官方模板实现
     */
    private static void officialInsertSort(int[] a) {
        if (a == null || a.length < 2)
            return;

        //第i次选择将 a[i+1]  插入到 a[0]..a[1]..a[i] 中，
        int n = a.length;
        for (int i = 1; i < n; i++) {    //单个元素有序，n个元素只需要插入n-1次，从1开始实际上就是只插入了n-1次
            int temp = a[i];     //提前存放a[i]，避免后面a[insert]...a[i-1]往右腾位置的时候把a[i]值覆盖
            int k = i - 1;

            //计算insertIndex,一直往左找直到某个元素比a[i]小,k >=0是避免往左边找过头了，
            while (k >= 0 && a[k] > a[i]) {
                k--;
            }
            //结束循环后，k指向往左找到的第一个比a[i]小的元素的下标，即a[k] < a[i] < a[k+1]   ,a[i]显然要在 k+1 的位置上插入
            //所以  a[k+1]..a[k+2]..a[i-1] 才是需要右移的元素，腾出来的位置是k+1

            //开始往右腾位置,a[insert]...a[i-1] 集体右移一位,
            //因为是右移，所以移动顺序是a[i-1]..a[i-2]...a[insert],如果方向反了会覆盖
            //当然a[i]也会被覆盖，但是我们上面已经用temp临时存放了a[i]的值
            for (int j = i - 1; j >= k + 1; j--) {
                a[j + 1] = a[j];
            }

            //把a[i]插入到计算出的 k+1 位置上
            a[k + 1] = temp;

            AlgorithmUtil.print(a);

        }
    }

    /**
     * 插入排序，个人在不参考官方例子下的实现
     * 理解思维的核心点不同之处在于：官方先计算出要腾出去的位置，然后往右挤把位置让出来，再直接把a[i]插进去
     * 我则是在交换的过程中就实现了插入
     */
    private static void myInsertSort(int[] a) {

        int n = a.length;

        for (int i = 1; i < n; i++) {                     //从第二个元素开始
            int pointIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[pointIndex]) {
                    int temp;
                    temp = a[j];
                    a[j] = a[pointIndex];
                    a[pointIndex] = temp;
                    pointIndex--;
                } else {
                    break;
                }
            }
            AlgorithmUtil.print(a);
        }
        AlgorithmUtil.print(a);
    }

    /**
     * 不需要交换的插入排序
     */
    private static void testInsertSort(int[] a) {

        int n = a.length;

        for (int i = 1; i < n; i++) {
            int temp = a[i];

            int j;   //为什么这里的j要在外面声明？

            for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                a[j + 1] = a[j];
            }

            //这个时候暂存值要插入的坐标为？
            a[j + 1] = temp;
            AlgorithmUtil.print(a);
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 1, 3, 4, 0, 7, 6, 8, 2};
        AlgorithmUtil.print(array);

        testInsertSort(array);
    }

}
