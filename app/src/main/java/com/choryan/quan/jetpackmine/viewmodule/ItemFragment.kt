package com.choryan.quan.jetpackmine.viewmodule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.frag_item_layout.*

/**
 * Created by ChoRyan Quan on 2021/11/18 15:28.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class ItemFragment : Fragment(R.layout.frag_item_layout) {

    private val mShareModule by lazy {
        activity?.let {
            ViewModelProvider(it).get(ShareViewModule::class.java)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_1.setOnClickListener {
            mShareModule?.itemLiveData?.value = "btn_1"
        }
        btn_2.setOnClickListener {
            mShareModule?.itemLiveData?.value = "btn_2"
        }
        btn_3.setOnClickListener {
            mShareModule?.itemLiveData?.value = "btn_3"
        }
        btn_4.setOnClickListener {
            mShareModule?.itemLiveData?.value = "btn_4"
        }
    }

}