package com.szy.lib_review.jvm

/**
 * Author：yangjunquan
 * Date:  2020/10/29
 * Desc: JVM的一些知识点
 */

/*
参考：https://www.zhihu.com/question/24304289

一些基础知识：

- 内存：即JVM内存，堆、栈、方法区都属于JVM内存
- .class文件：字节码文件 （.java源码是给认类看的，而.class字节码是给计算机读的。根据不同的理解规则，可以产生不同的意思。JVM对.class文件拥有自己的一套读取规则）


代码执行的简单过程：
JVM启动，代码编译成一个.class文件，然后被类加载器ClassLoader加载到jvm的内存中，创建了类的class对象到
每个类只有一个class对象，jvm实例化一个具体的类对象时，首先会检查类是否加载，虚招类对应的class对象，若加载好，则为新建的对象分配内存，然后进行相应的初始化操作.


 */

/**
 * 图片链接：https://pic2.zhimg.com/80/v2-eddc430b991c58039dfc79dd6f3139cc_720w.jpg?source=1940ef5c
 * A a=new A(); 创建对象的过程？
 * 1)加载类
 *    ClassLoader加载对应的.class文件到内存，然后执行静态代码块和静态初始化语句
 * 2)执行new，申请一片内存空间
 * 3)调用构造器，创建一个空白对象
 * 4)子类调用父类构造器
 * 5)构造器执行：执行构造代码块、初始化语句、构造器内容
 */
