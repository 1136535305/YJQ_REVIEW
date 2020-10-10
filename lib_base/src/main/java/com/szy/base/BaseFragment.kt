package com.szy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass


abstract class BaseFragment<VM : ViewModel, V : ViewDataBinding> : Fragment() {

    lateinit var mViewModel: VM
    lateinit var mViewBinding: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)

        return mViewBinding.root
    }

    abstract fun getLayoutResId(): Int

    abstract fun initData()

    abstract fun initView()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()

        initData()

        initView()
    }

    private fun initViewModel() {

        val clazz = javaClass.kotlin.supertypes[0].arguments[0].type!!.classifier!! as KClass<VM>
        mViewModel = getViewModel<VM>(clazz) //koin 注入

    }

}