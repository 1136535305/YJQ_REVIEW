package com.szy.lib_review.algorithms;

/**
 * Name: Algorithms
 * Author: YJQ
 * Date: 2020/4/21
 * Desc:算法介绍
 * Note:    https://www.cnblogs.com/itsharehome/p/11058010.html
 */
public class AlgorithmTest {

    /**
     * 术语解释
     * 有些人可能不知道什么是稳定排序、原地排序、时间复杂度、空间复杂度，我这里先简单解释一下：
     * ①稳定排序：如果 a 原本在 b 的前面，且 a == b，排序之后 a 仍然在 b 的前面，则为稳定排序。
     * ②非稳定排序：如果 a 原本在 b 的前面，且 a == b，排序之后 a 可能不在 b 的前面，则为非稳定排序。
     * ③原地排序：原地排序就是指在排序过程中不申请多余的存储空间，只利用原来存储待排数据的存储空间进行比较和交换的数据排序。
     * ④非原地排序：需要利用额外的数组来辅助排序。
     * ⑤时间复杂度：一个算法执行所消耗的时间。
     * ⑥空间复杂度：运行完一个算法所需的内存大小。
     *
     *
     * API:你需要理解对数？ http://www.360doc.com/content/18/0306/11/11935121_734689558.shtml
     *     a的X次方等于N，那么数x叫做以a为底，N的对数（logarithm），记作x=logaN。其中，a叫做对数的底数，N叫做真数。 [1]
     *     a称之为底数，X称之为幂，N称之为真数，
     *     指数与对数是对逆关系。
     *
     * NOTE:如何计算时间复杂度？ https://blog.csdn.net/szlg510027010/article/details/82426240
     *  1.找到执行次数最多的语句；
     *  2.语句执行语句的数量级；
     *  3.用O表示结果；
     *  然后：
     *  4.用常数1取代运行时间中的所有加法常数；
     *  5.在修改后的运行次数函数中，只保留最高阶项
     *  6.如果最高阶像存在且不是1，去掉这个项相乘的次数。比如3n^2 我们取 n^2
     *
     * ----------------------------------------------------------------------------------------------
     *  NOTE:等差数列求和公式  1+2+3+..+ n
     *    Sn = n a1  +   n(n-1)/2 * d
     *    a n= a1 + （n-1）*d
     * ----------------------------------------------------------------------------------------------
     *
     *  Note:时间复杂度比较
     *   O(1 )< O(logn) < O(n) < O(n*logn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)
     *
     *
     *  Note：
     *     时间复杂度里的log 指的都是 log 2.
     *     假设数组有8个有序元素，简单查找法最坏要找8次，而使用二分查找法，最多需要找log n 个元素，n=8时，由于2^3=8,那么需要找3次。
     *
     *  Note：
     *   我们提到的运行时间都是最坏的运行时间
     */


    /**
     * 算法测试入口
     */
    public static void main(String[] args) {


        //printArray(array);

        //选择排序
        //selectSort(array);
        //mySelectSort(array);
        //testSelectSort(array);

        //插入排序
        //myInsertSort(array);
        //officialInsertSort(array);
        //testInsertSort(array);


        //冒泡排序
        //myBubbleSort(array);
        // officialInsertSort(array);
        //testBubbleSort(array);
    }


    private static void printArray(int[] array) {
        int length = array.length;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(" ").append(array[i]).append(" ");
            if (i != length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }


    /**
     *
     */


}