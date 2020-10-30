package com.szy.lib_review.dependency;

/**
 * Name: ModuleDependencyTest
 * Author: YJQ
 * Date: 2020/4/20
 * Desc: 这里分析模块间的依赖关系
 * 详细介绍：https://www.jianshu.com/p/8962d6ba936e
 */
public class ModuleDependency {


    /**
     * 【运行时】：就是项目实际跑起来的时候
     * 【编译时】：就是我们直接在ide编写的时候
     *------------------------------------------------------------------------------------------------------------------------------------
     *  implementation     当你的module 使用 implementation 这种依赖方式时，相当于告诉Gradle 【在编译时】 这个module不想要暴露自己所依赖的东西给
     *                     其它module 。这就意味着，这种依赖仅仅会在【运行时】对其它module时可见的。
     *
     *                     使用 implementation去依赖项目而不使用api或者compile对减少构建时间非常有用，因为它减少了【build system】 需要【rebuild】时
     *                     的【projects】。举例：B implementation C ，然后C的API发生了变化，Gradle仅仅会【recompile】直接依赖C的项目。
     *                     如果又有其它A module依赖了B（不管是哪种依赖方式），A module都不需要recompile。
     *                     即： A 依赖 B ，B implement C , C的API如果发生了变化 ，那么只有B需要recompile，
     *                         同时因为B module不想要暴露自己的依赖关系，在A中是没有办法获取到C的API的。
     *-------------------------------------------------------------------------------------------------------------------------------------
     * api                当你的module 使用 api 这种依赖方式时 ，相当于通知Gradle【在编译时】这个module 想要传递它的依赖给其它module。
     *                    这就意味着，这种依赖会在【运行时】和【编译时】都对其它module时可见的。
     *                    所以只有当需要依赖一个【library modules】（如：图片加载框架、）时才使用api。
     *                    这是因为，如果一个api dependency 改变了它的外部API时，Gradle 在【编译时】会重新构建 所有Module。
     *                    拥有着大量modules的项目，如果滥用api，会导致所有能够access to 这个项目 的Module，都要重新构建
     *                    app Module（顶级module）应该使用 implementation 这种依赖方式
     *-------------------------------------------------------------------------------------------------------------------------------------
     * 举个例子                                    App
     *                              moduleA     moduleB     moduleC
     *                              moduleD     moduleE     moduleF
     *                                          moduleG
     *
     *   如果 【moduleD     api        moduleG】        一旦moduleG发生了变化，Gradle  需要重新编译 moduleG、moduleD、moduleA
     *   如果 【moduleD implementation moduleG】        一旦moduleG发生了变化，Gradle只需要重新编译 moduleG、moduleD （因为moduleA 不知道 moduleG的存在）
     *
     *   作用：这样可以节省build time
     * -------------------------------------------------------------------------------------------------------------------------------------
     */

    //NOTE:换一句话说，就是api是对外的，就应该公开；而implementation是内部的实现，不应该公开出来，起到了一个依赖隔离的作用。
    //API: 如果app想要获取baseModule里的API ，那么 【jdModule  api baseModule】 或者  【 miModule api baseModule】

    /* API: 这里module层次如下
                 app
       jdModule         miModule
              baseModule
     */
}
