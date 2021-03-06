package com.szy.lib_review.value_pass;

/**
 * Name: ValuePass
 * Author: YJQ
 * Date: 2020/4/23
 * Note：Java都是值传递 https://www.cnblogs.com/wchxj/p/8729503.html
 */
public class ValuePass {


    /**
     * Note:如果你还抱有以下这些错误看法，你需要好好理解一下：
     *      错误理解一：值传递和引用传递，区分的条件是传递的内容，如果是个值，就是值传递，如果是个引用，就是引用传递
     *      错误理解二：Java引用传递
     *      错误理解三：传递的参数如果是普通类型，那就是值传递，如果是对象，那就是引用传递
     *
     * 注意我们要区分传递的值到底实际上代表什么，Java都是值传递。
     * 只不过有时候这个值代表的是一个地址，有时候代表的是一个值
     *
     *
     *
     * Note：区分清楚形参和实参，了解【形参】到【实参】这个过程实际上是一个复制的过程，复制的都是值
     *   【值传递】是指调用函数时将  实际参数  复制一份到传递到函数中，这样在函数中如果对参数进行修改，不会影响到实际参数。（情景一：引用既实际参数没有改变，但是引用指向的内存空间里的值被改变了。）
     *    Java采用的都是值传递。
     *
     * 举个例子：
     *     int[] a =new int[3];  //省去初始化过程
     *
     *  疑问
     *    1. a代表什么？
     *      代表一个数组的内存地址起始处
     *    2. a[0]代表什么？
     *       从起始地址为 a 内存处，选取第 1个元素，
     *    3.如果a[0] 此时被赋值了，代表内存里存放的值被永久性改变了
     *    4.但是如果是a赋值了，表明a（实际上是一个数组引用），这个引用指向了新的内存空间。
     *
     *
     *    5.仔细研究这个例子：告诉我会输出什么（看会不会影响原有值要看在实际上有没有真正修改了内存的值）
     *----------------------------------------------------------------------
     *    public static void main(String[] args) {
     *    ParamTest pt = new ParamTest();
     *
     *    String name = "Hollis";
     *    pt.pass(name);
     *    System.out.println("print in main , name is " + name);
     * }
     *
     * public void pass(String name) {     //复制的是一个引用
     *    name = "hollischuang";           //这个引用被指向了新的内存空间，它的地址变化了
     *                                     //改变了钥匙，现在钥匙指向了新的房子了
     *    System.out.println("print in pass , name is " + name);
      }
     * ----------------------------------------------------------------------------
     * 最后分别输出： hollischuang、hollis
     *
     * Note：如果传的是地址，要看这个地址指向的内容有没有变化
     *
     * 个人理解：复制了一份name的引用，然后这个复制的引用又被指向了新的内存空间，
     *          所以即使后面对这个应用做任何操作都不会影响实际参数，更不会影响实际参数指向的对象。
     *
     */


    /**
     *一般来说如果对象在方法中传递，如果你想在新方法中改变原有对象的值，不要对这个地址重新指向从而更改地址的值
     * 否则就开辟一个新的内存间，把原有对象的值放进去
     */

}
