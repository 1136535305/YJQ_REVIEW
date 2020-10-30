package com.szy.lib_review.base

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

/**
 * Author：yangjunquan
 * Date:  2020/10/29
 * Desc:
 */
abstract class RVBaseDialogFragment<V : ViewDataBinding> : DialogFragment() {


    var dismissCallBack: (() -> Unit)? = null

    lateinit var mBinding: V
    abstract fun getLayoutResId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initParams()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        initView()
        return mBinding.root
    }

    abstract fun initView()


    open fun initParams() {
        dialog?.window?.attributes?.apply {
            gravity = Gravity.CENTER
        }
    }
}