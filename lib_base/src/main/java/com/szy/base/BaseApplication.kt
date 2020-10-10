package com.szy.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.szy.base.util.LogUtil

/**
 * Author：yangjunquan
 * Date:  2020/10/10
 * Desc:
 */
class BaseApplication : Application() {

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

        //Logger 日志打印工具类
        LogUtil.init()
    }
}