package com.choryan.quan.jetpackmine.mvvm.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.choryan.quan.jetpackmine.mvvm.utils.StatusBarUtils

/**
 * Created by SpiderMan on 2022/8/18 18:48.
 * Function :
 */
abstract class BaseViewBindingActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM

    protected lateinit var binding: VB


    abstract fun provideVMClass(): Class<VM>

    abstract fun getViewBinding(): VB

    abstract fun initData()

    abstract fun initView()

    private fun initVM() {
        provideVMClass().let {
            viewModel = ViewModelProvider(this)[it]
            lifecycle.addObserver(viewModel)
        }
    }

    private fun startObserve() {
        //处理一些通用异常，比如网络超时等
        viewModel.run {
            getError().observe(this@BaseViewBindingActivity) {
                requestError(it)
            }
            getFinally().observe(this@BaseViewBindingActivity) {
                requestFinally(it)
            }
        }
    }

    //接口请求完毕，子类可以重写此方法做一些操作
    open fun requestFinally(it: Int?) {}

    //接口请求出错，子类可以重写此方法做一些操作
    open fun requestError(it: Exception?) {
        //处理一些已知异常
        it?.run {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initVM()
        //禁止自动切换横竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //防止输入法顶起底部布局
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        super.onCreate(savedInstanceState)

        //设置状态栏透明
        StatusBarUtils.setWindowStatusTransparent(this)

        binding = getViewBinding()
        if (this::binding.isInitialized) {
            setContentView(binding.root)
        }

        initData()
        initView()
        startObserve()

    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }
}