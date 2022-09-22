package com.choryan.quan.jetpackmine.mvvm.repository

import com.choryan.quan.jetpackmine.mvvm.base.BaseRepository
import com.choryan.quan.jetpackmine.mvvm.http.ResponseData
import com.choryan.quan.jetpackmine.mvvm.http.RetrofitClient
import com.choryan.quan.jetpackmine.mvvm.http.TodoResponseBody

/**
 * Created by Ryan on 2022/8/19 15:05.
 * Function :在这里，真正对数据进行操作
 */
open class CommonRepository : BaseRepository() {

    suspend fun getTodoList(page: Int, map: MutableMap<String, Any>): ResponseData<TodoResponseBody> = request {
        RetrofitClient.service.getTodoList(page, map)
    }

}