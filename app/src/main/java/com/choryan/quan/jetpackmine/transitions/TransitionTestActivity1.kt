package com.choryan.quan.jetpackmine.transitions

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Pair
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.activity_transition_1.*

/**
 * Created by ChoRyan Quan on 2021/11/23 14:52.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class TransitionTestActivity1 : AppCompatActivity(R.layout.activity_transition_1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv_activity_1.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair(tv_activity_1, "tv_activity_1"),
                Pair(btn_activity_1, "btn_activity_1")
            )
            TransitionTestActivity2.start(this, options.toBundle())
        }
    }

}