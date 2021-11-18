package com.choryan.quan.jetpackmine.motionlayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.floatbar_motion_layout.*

/**
 * Created by ChoRyan Quan on 2021/11/11 15:46.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class MotionLayoutActivity : AppCompatActivity(R.layout.floatbar_motion_layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cl_1.setOnClickListener {
            Toast.makeText(this, "cl_1", Toast.LENGTH_SHORT).show()
        }

    }

    companion object {
        private const val TAG = "MotionLayoutActivity"
    }

}