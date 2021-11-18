package com.choryan.quan.jetpackmine.viewmodule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by ChoRyan Quan on 2021/11/18 15:19.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class ShareViewModule : ViewModel() {
    val itemLiveData = MutableLiveData<String>()
}