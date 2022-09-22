package com.choryan.quan.jetpackmine.mvvm.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choryan.quan.jetpackmine.mvvm.constant.Constant
import com.choryan.quan.jetpackmine.mvvm.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

/**
 * Created by Ryan on 2022/8/18 18:51.
 * Function :
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val error by lazy { SingleLiveEvent<Exception>() }

    private val finally by lazy { SingleLiveEvent<Int>() }

    //运行在UI线程的协程
    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        try {
            withTimeout(Constant.DEFAULT_TIMEOUT * 1_000L) {
                block()
            }
        } catch (e: Exception) {
            error.setValue(e)
        } finally {
            finally.setValue(200)
        }
    }

    fun getError(): LiveData<Exception> = error

    fun getFinally(): LiveData<Int> = finally

}