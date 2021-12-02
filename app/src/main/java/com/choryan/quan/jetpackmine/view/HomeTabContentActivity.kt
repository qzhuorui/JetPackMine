package com.choryan.quan.jetpackmine.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.activity_home_tab_content.*

/**
 * Created by ChoRyan Quan on 2021/12/2 12:19.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class HomeTabContentActivity : AppCompatActivity(R.layout.activity_home_tab_content) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var animRunning = false

        home_tab_btn_1.setOnClickListener {
            if (!animRunning) {
                motion_parent.setTransition(R.id.action_1)
                motion_parent.transitionToEnd()
            }
        }
        home_tab_btn_2.setOnClickListener {
            if (!animRunning) {
                motion_parent.setTransition(R.id.action_2)
                motion_parent.transitionToEnd()
            }
        }
        home_tab_btn_3.setOnClickListener {
            if (!animRunning) {
                motion_parent.setTransition(R.id.action_3)
                motion_parent.transitionToEnd()
            }
        }
        motion_parent.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                animRunning = true
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                animRunning = false
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

        })
    }

}