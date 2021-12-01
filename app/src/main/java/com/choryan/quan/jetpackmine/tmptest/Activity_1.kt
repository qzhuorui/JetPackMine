package com.choryan.quan.jetpackmine.tmptest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.activity_1.*

/**
 * Created by ChoRyan Quan on 2021/11/25 16:27.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class Activity_1 : AppCompatActivity(R.layout.activity_1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv_1.setOnClickListener {
            it.postDelayed({
                Log.d("test", "1_start: ")
                startActivity(Intent(this, Activity_2::class.java))
                Log.d("test", "1_end: ")
            }, 3000L)
        }
        tv_close.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "1_destroy: ")
    }

}