package com.szy.lib_review.design_mode;

/**
 * Name: SingleInstance
 * Author: YJQ
 * Date: 2020/4/9
 * Desc: 双重锁单例模式
 */
public class SingleInstance {
    //static
    private static volatile SingleInstance INSTANCE;


    //私有构造方法，防止外部私自使用构造函数初始化
    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        if (INSTANCE == null) {                     //Ⅰ.对象创建完毕后，执行getInstance()方法不再需要获取锁，直接返回已经创建好的对象。
            synchronized (SingleInstance.class) {   //Ⅱ.对象创建完毕前，若多个线程试图在同一时间创建对象，通过加锁确保只有一个线程能创建对象。
                if (INSTANCE == null) {
                    INSTANCE = new SingleInstance();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Note：可能导致问题的根源代码
     *   INSTANCE = new SingleInstance();
     *  这一行代码可以被分解成3行伪代码：  // 1.分配对象的内存空间
     *                                 //  2.初始化对象
     *                                //  3.设置INSTANCE指向刚分配的内存地址
     *  2、3步骤可能会被重排序（因为这种重排序不违背intra-thread semantics 即线程内语义），导致的结果：
     *     INSTANCE引用指向了一个还没有初始化的对象
     *    如果此时线程A还在执行操作2，线程B已经开始访问使用对象，
     *    此时INSTANCE不为null，所以线程B的getInstance方法直接返回INSTANCE(但实际上对象仍在等待线程A完成对象初始化)
     *    最终，线程B可能会访问到一个还未初始化的对象。
     */


    /**
     * API:解决方法：1)禁止2、3重排序
     *              2)允许2、3重排序，但是不允许其它线程"看到"这个变化
     *  Ⅰ.基于volatile的解决方案：private static volatile INSTANCE; (这种方案禁止了和2、3的重排序)
     *  Ⅱ.基于类初始化的解决方案:
     *  <pre>
     *       public class InstanceFactory{
     *           private static class InstanceHolder{
     *               public static Instance instance=new Instance();   //缺点：初始化时无法传递参数
     *           }
     *           public static Instance getInstance(){
     *               return InstanceHolder.instance;
     *           }
     *       }
     * </pre>
     */
}
