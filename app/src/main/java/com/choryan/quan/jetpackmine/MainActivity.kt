package com.choryan.quan.jetpackmine

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.motionlayout.MotionLayoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initClick()
    }

    private fun initClick() {
        tv_motionLayout.setOnClickListener {
            startActivity(Intent(this, MotionLayoutActivity::class.java))
        }
    }
}