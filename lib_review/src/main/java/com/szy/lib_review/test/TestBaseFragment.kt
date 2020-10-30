package com.szy.lib_review.test

import com.szy.lib_review.R
import com.szy.lib_review.base.RVBaseDialogFragment
import com.szy.lib_review.databinding.DialogTestBinding

/**
 * Author：yangjunquan
 * Date:  2020/10/29
 * Desc:
 */
class TestBaseFragment : RVBaseDialogFragment<DialogTestBinding>() {

    override fun getLayoutResId(): Int {
        return R.layout.dialog_test
    }

    override fun initView() {
        isCancelable = false
    }

}