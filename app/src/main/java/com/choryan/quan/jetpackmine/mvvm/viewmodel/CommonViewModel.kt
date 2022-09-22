package com.choryan.quan.jetpackmine.mvvm.viewmodel

import androidx.lifecycle.LiveData
import com.choryan.quan.jetpackmine.mvvm.base.BaseViewModel
import com.choryan.quan.jetpackmine.mvvm.http.TodoResponseBody
import com.choryan.quan.jetpackmine.mvvm.repository.CommonRepository
import com.choryan.quan.jetpackmine.mvvm.utils.SingleLiveEvent

/**
 * Created by Ryan on 2022/8/19 14:53.
 * Function :通用ViewModel
 */
open class CommonViewModel : BaseViewModel() {

    //数据操作具柄
    private val repository = CommonRepository()


    var todoData = SingleLiveEvent<TodoResponseBody>()

    /**
     * 如果需要对返回的数据进行操作后再返回给调用者
     * 可以使用Transformations.map(todoData) {}或 Transformations.switchMap(todoData){}对data进行处理
     */
    fun getTodoList(page: Int, map: MutableMap<String, Any>): LiveData<TodoResponseBody> {
        launchUI {
            //UI Thread
            val res = repository.getTodoList(page, map)
            todoData.setValue(res.data)
        }
        return todoData
    }

}