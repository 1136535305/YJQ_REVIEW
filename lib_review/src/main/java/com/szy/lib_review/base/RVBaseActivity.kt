package com.szy.lib_review.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Author：yangjunquan
 * Date:  2020/10/12
 * Desc: 内存泄漏常见例子
 */
abstract class RVBaseActivity<V : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding: V
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        initView()
    }

    abstract fun getLayoutResId(): Int

    abstract fun initView()
}