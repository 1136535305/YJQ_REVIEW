package com.szy.lib_review.memory_leak

import com.szy.lib_review.R
import com.szy.lib_review.base.RVBaseActivity
import com.szy.lib_review.databinding.ActivityMemoryLeakBinding

/**
 * 内存泄漏经典例子
 * ①Handler造成的内存泄漏
 * ②生命周期长的对象持有生命周期短的对象的强引用，导致后者正常退出后GC无法回收后者的内存
 */
class MemoryLeakActivity : RVBaseActivity<ActivityMemoryLeakBinding>() {
    override fun getLayoutResId() = R.layout.activity_memory_leak

    override fun initView() {

    }
}
