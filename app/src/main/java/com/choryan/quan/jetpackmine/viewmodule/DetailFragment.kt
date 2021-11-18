package com.choryan.quan.jetpackmine.viewmodule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.frag_detail_layout.*
import kotlinx.android.synthetic.main.frag_item_layout.*

/**
 * Created by ChoRyan Quan on 2021/11/18 15:28.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class DetailFragment : Fragment(R.layout.frag_detail_layout) {

    private val mShareModule by lazy {
        activity?.let {
            ViewModelProvider(it).get(ShareViewModule::class.java)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mShareModule?.itemLiveData?.observe(requireActivity()) {
            tv_detail.text = it
        }
    }

}