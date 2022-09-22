package com.choryan.quan.jetpackmine.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 * Created by Ryan on 2022/8/19 14:27.
 * Function :
 */
abstract class BaseViewBindingFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    val activity: BaseViewBindingActivity<*, *> by lazy { requireActivity() as BaseViewBindingActivity<*, *> }

    protected lateinit var viewModle: VM

    protected lateinit var binding: VB

    abstract fun provideVMClass(): Class<VM>?

    abstract fun getViewBinding(): VB

    abstract fun initData()

    abstract fun initView()

    private fun initVM() {
        provideVMClass()?.let {
            viewModle = ViewModelProvider(this)[it]
            lifecycle.addObserver(viewModle)
        }
    }

    private fun startObserve() {
        //处理一些通用异常，比如网络超时等
        viewModle.run {
            getError().observe(activity) {
                requestError(it)
            }
            getFinally().observe(activity) {
                requestFinally(it)
            }
        }
    }

    open fun requestFinally(it: Int?) {

    }

    open fun requestError(it: Exception?) {
        //处理一些已知异常
        it?.run {
            when (it) {

            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVM()
        initData()
        initView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObserve()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::viewModle.isInitialized)
            lifecycle.removeObserver(viewModle)
    }

}