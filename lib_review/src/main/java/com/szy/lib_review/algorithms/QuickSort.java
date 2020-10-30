package com.szy.lib_review.algorithms;

/**
 * Name: QuickSort
 * Author: YJQ
 * Date: 2020/4/23
 * Desc:
 */
public class QuickSort {
//API:快速排序 https://www.cnblogs.com/itsharehome/p/11058010.html
//           时间复杂度：O(nlogn)    空间复杂度：O(logn)   非稳定排序   原地排序
//   1.选择一个中轴元素，数组中小于中轴元素的元素放在其左边，所有大于或者等于中轴元素的元素放在其右边，此时中轴元素有序。
//   2.根据中轴元素分割两个数组，通过递归的方式，让中轴元素左边的数组和右边的数组重复同样的操作，直到数组的大小为1，直到数组的大小为1，此时每个元素都有序。


//API:分析
//   快速排序是不稳定的，毕竟要远距离的调换元素。
//   最佳和平均情况下 T(n) = O(nlogn)，最差情况下 T(n) = O(n2)。
//   快速排序的实现依赖的是递归加二分法，但这个二分法并不是完美的二分法。
//          如果二分法每次正好只分到一边，那么一共就有 n-1 层，每一层比较key的次数都近似于N，所以时间复杂度是 n2；
//          其他情况下一共有logn 层，每层都需要跟key作比较，比较次数近似于N，所以时间复杂度是 n*logn。
// 快速排序的时间复杂度分析：树形结合图 ：https://blog.csdn.net/qq_25424545/article/details/80068682


    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 1, 3, 4, 0, 7, 6, 8, 2};
        int n = array.length;
        AlgorithmUtil.print(array);
        myQuickSort(array, 0, n - 1);
        AlgorithmUtil.print(array);

    }


    public static void myQuickSort(int[] a, int left, int right) {
        if (right <= left) return;               //递归的结束条件

        int mid = partition(a, left, right);     //切分
        myQuickSort(a, left, mid - 1);     //将左半部分a[left ...   mid-1]排序
        myQuickSort(a, mid + 1, right);     //将右半部分a[mid+1 .... right]排序
    }

    //Note：这种排序方式为什么要返回中轴元素移动过后的坐标？
    // 找出中轴元素，并把这个中轴元素放在合适的地方，这样一次找完就能确定该中轴元素应该在数组中的位置
    // 我们每一次分组都是把中轴元素放到了恰当的位置
    private static int partition(int[] a, int left, int right) {

        int i = left, j = right + 1;     //i,j分别表示左右扫描指针
        int pivot = a[left];             //选择切分元素

        //扫描左右，检查扫描是否结束并交换元素
        while (true) {

            while (a[++i] < pivot) if (i == right) break;
            while (a[--j] > pivot) if (j == left) break;

            if (i >= j) break;
            AlgorithmUtil.swap(a, i, j);
        }

        //找不到即没有交换这时候才会退出，此时 i>=j
        AlgorithmUtil.swap(a, left, j);
        return j;
    }


}
