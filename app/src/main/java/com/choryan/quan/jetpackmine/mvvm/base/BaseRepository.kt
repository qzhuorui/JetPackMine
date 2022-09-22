package com.choryan.quan.jetpackmine.mvvm.base

import android.util.Log
import com.choryan.quan.jetpackmine.mvvm.http.ResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Ryan on 2022/8/19 14:56.
 * Function :
 */
open class BaseRepository {

    suspend fun <T : Any> request(call: suspend () -> ResponseData<T>): ResponseData<T> {
        return withContext(Dispatchers.IO) {
            call.invoke()
        }.apply {
            Log.d("BaseRepository", "request: ${this.toString()}")
        }
    }

}