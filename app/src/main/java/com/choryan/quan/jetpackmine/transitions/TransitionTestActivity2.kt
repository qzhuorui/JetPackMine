package com.choryan.quan.jetpackmine.transitions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeClipBounds
import android.transition.ChangeImageTransform
import android.transition.TransitionSet
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R

/**
 * Created by ChoRyan Quan on 2021/11/23 14:52.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class TransitionTestActivity2 : AppCompatActivity(R.layout.activity_transition_2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        readyAnimation()
        super.onCreate(savedInstanceState)
    }

    private fun readyAnimation() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        val transitionSet = TransitionSet()
        transitionSet.addTransition(ChangeBounds())
        transitionSet.addTransition(ChangeClipBounds())
        transitionSet.addTransition(ChangeImageTransform())
        window.sharedElementEnterTransition = transitionSet
        window.sharedElementExitTransition = transitionSet
    }

    companion object {
        fun start(context: Context, bundle: Bundle) {
            val intent = Intent(context, TransitionTestActivity2::class.java)
            context.startActivity(intent, bundle)
        }
    }
}