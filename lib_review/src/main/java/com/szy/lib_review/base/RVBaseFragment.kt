package com.szy.lib_review.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Author：yangjunquan
 * Date:  2020/10/12
 * Desc:
 */
abstract class RVBaseFragment<V : ViewDataBinding> : Fragment() {
    lateinit var mBinding: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        initView()
        return mBinding.root
    }

    abstract fun getLayoutResId(): Int

    abstract fun initView()
}