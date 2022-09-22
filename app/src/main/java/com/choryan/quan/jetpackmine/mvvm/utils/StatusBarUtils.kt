package com.choryan.quan.jetpackmine.mvvm.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.Window
import android.view.WindowManager
import com.choryan.quan.jetpackmine.R

/**
 * Created by Ryan on 2022/8/19 14:18.
 * Function :
 */
object StatusBarUtils {

    fun setWindowStatusTransparent(activity: Activity) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window: Window = activity.window
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = activity.resources.getColor(R.color.transparent)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //5.0以上版本去掉状态栏阴影
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                val decorViewClazz =
                    Class.forName("com.android.internal.policy.DecorView")
                val field = decorViewClazz.getDeclaredField("mSemiTransparentStatusBarColor")
                field.isAccessible = true
                field.setInt(activity.window.decorView, Color.TRANSPARENT) //改为透明
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}