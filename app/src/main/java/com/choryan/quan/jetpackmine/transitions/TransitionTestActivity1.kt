package com.choryan.quan.jetpackmine.transitions

import android.app.ActivityOptions
import android.os.Bundle
import android.util.Pair
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.android.synthetic.main.activity_transition_1.*

/**
 * Created by ChoRyan Quan on 2021/11/23 14:52.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class TransitionTestActivity1 : AppCompatActivity(R.layout.activity_transition_1) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        cl_parent.setOnClickListener {
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair(cl_parent, "cl_parent")
            )
            TransitionTestActivity2.start(this, options.toBundle())
        }
    }

}