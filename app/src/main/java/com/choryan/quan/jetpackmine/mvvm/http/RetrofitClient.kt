package com.choryan.quan.jetpackmine.mvvm.http

import android.util.Log
import com.choryan.quan.jetpackmine.mvvm.constant.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Ryan on 2022/8/19 15:12.
 * Function :
 */
object RetrofitClient {

    val Base_URL = "https://wanandroid.com/"

    private var retrofit: Retrofit? = null

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Base_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val service: ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }


    /**
     * 获取 OkHttpClient
     */
    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        val loggingInterceptor: HttpLoggingInterceptor
//        if (BuildConfig.DEBUG) {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
//        }

//        if (BuildConfig.DEBUG) {
        loggingInterceptor =
            HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Log.d("接口请求log----->", message)
                }
            })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else loggingInterceptor = HttpLoggingInterceptor()

        //设置 请求的缓存的大小跟位置
        //val cacheFile = File(mContext.cacheDir, "cache")
        //val cache = Cache(cacheFile, HttpConstant.MAX_CACHE_SIZE)

        builder.run {
            addInterceptor(loggingInterceptor)
            //cache(cache)  //添加缓存
            connectTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true) // 错误重连
        }
        return builder.build()
    }

}