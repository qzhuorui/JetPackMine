package com.choryan.quan.jetpackmine.mvvm.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by Ryan on 2022/8/18 18:55.
 * Function :解决LiveData粘性事件
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val flag: AtomicBoolean = AtomicBoolean(false)

    override fun setValue(value: T) {
        flag.set(true)
        super.setValue(value)
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) {
            //CAS，如果flag true的话，就改为false，并且返回true
            if (flag.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        }
    }

}