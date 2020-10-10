package com.szy.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

/**
 * Author：yangjunquan
 * Date:  2020/10/10
 * Desc:
 */
abstract class BaseActivity<VM : ViewModel, V : ViewDataBinding> : AppCompatActivity() {

    lateinit var mViewModel: VM
    lateinit var mViewBinding: V

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutResId())

        initViewModel()

        initData()

        initView()
    }


    private fun initViewModel() {
        val clazz = javaClass.kotlin.supertypes[0].arguments[0].type!!.classifier!! as KClass<VM>
        mViewModel = getViewModel(clazz) //koin 注入
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun getLayoutResId(): Int
}