package com.szy.lib_review.algorithms;

/**
 * Name: ArrayUtil
 * Author: YJQ
 * Date: 2020/4/23
 * Desc:
 */
public class AlgorithmUtil {
    public static void print(int[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }


    /**
     * Note：区分形参与实参
     *  （方法调用处）实际参数：在调用有参函数时，主调函数和被调函数之间有数据传递关系。在主调函数中调用一个函数时，函数名后面括号中的参数称为“实际参数”。
     *  （方法声明处）形式参数：是在定义函数名和函数体的时候使用的参数,目的是用来接收调用该函数时传入的参数。
     *
     * 我们调用一个有参函数时，会把实际参数传递给形式参数。
     * 但是在程序语言中，这个传递过程有两种方式：
     *   ①值传递  ；  把实际参数     复制一份到函数中，这样在函数中如果对参数进行修改，不会影响到实际参数
     *   ②引用传递：  把实际参数的地址直接传递到函数中，这样在函数中如果对参数进行修改，会影响到实际参数
     */


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
