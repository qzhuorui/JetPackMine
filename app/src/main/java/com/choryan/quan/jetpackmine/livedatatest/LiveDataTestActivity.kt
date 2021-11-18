package com.choryan.quan.jetpackmine.livedatatest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.live_data_test_activity_layout.*

/**
 * Created by ChoRyan Quan on 2021/11/11 15:46.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class LiveDataTestActivity : AppCompatActivity(R.layout.live_data_test_activity_layout) {

    private var mFragment: LiveDataTestFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLiveDataTestFragment()
        btn_create_num.setOnClickListener {
            sendDataValue()
        }
        btn_add_frag.setOnClickListener {
            addLiveDataTestFragment()
        }
        btn_del_frag.setOnClickListener {
            delLiveDataTestFragment()
        }
    }

    private fun addLiveDataTestFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fl_content)
        if (fragment != null) {
            Toast.makeText(this, "error_重复添加", Toast.LENGTH_SHORT).show()
            return
        }
        if (mFragment == null) {
            mFragment = LiveDataTestFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_content, mFragment!!)
            .commitAllowingStateLoss()
    }

    /**
     * 移除Frag后，再次setValue，Frag中不会收到value。生命周期感知，observer不会被触发。
     */
    private fun delLiveDataTestFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fl_content)
        if (fragment == null) {
            Toast.makeText(this, "error_没有Fragment", Toast.LENGTH_SHORT).show()
            return
        }
        supportFragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss()
    }

    private fun sendDataValue() {
        val randomValue = (0..1000).random().toString()
        tv_livedata.text = "Activity中发送：$randomValue"
        LiveDataInstance.INSTANCE.value = randomValue
    }

    /**
     * 同理，生命周期感知，Frag中Observer不会被触发。
     */
    override fun onStop() {
        super.onStop()
        LiveDataInstance.INSTANCE.value = "ryan"
        Log.d("test", "onStop: send liveData")
    }

}