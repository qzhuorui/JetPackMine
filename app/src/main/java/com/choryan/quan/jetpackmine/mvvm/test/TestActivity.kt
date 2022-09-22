package com.choryan.quan.jetpackmine.mvvm.test

import com.choryan.quan.jetpackmine.databinding.ActivityTestViewBindingBinding
import com.choryan.quan.jetpackmine.mvvm.base.BaseViewBindingActivity
import com.choryan.quan.jetpackmine.mvvm.viewmodel.CommonViewModel

/**
 * Created by Ryan on 2022/8/19 14:51.
 * Function :
 */
class TestActivity : BaseViewBindingActivity<CommonViewModel, ActivityTestViewBindingBinding>() {

    override fun provideVMClass(): Class<CommonViewModel> = CommonViewModel::class.java

    override fun getViewBinding(): ActivityTestViewBindingBinding =
        ActivityTestViewBindingBinding.inflate(layoutInflater)

    override fun initData() {

        //请求接口
        val dataMap = mutableMapOf<String, Any>()
        dataMap["status"] = 1
        viewModel.getTodoList(0, dataMap)

        //监听接口数据
        viewModel.todoData.observe(this){

        }
    }

    override fun initView() {
        TODO("Not yet implemented")
    }


}