package com.choryan.quan.jetpackmine.livedatatest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.live_data_test_fragment_layout.*

/**
 * Created by ChoRyan Quan on 2021/11/18 11:23.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class LiveDataTestFragment : Fragment(R.layout.live_data_test_fragment_layout) {

    companion object {
        fun newInstance() = LiveDataTestFragment()
    }

    private val transformLiveData =
        Transformations.map(LiveDataInstance.INSTANCE) { "Transform:$it" }

    private val changeObserver = Observer<String> {
        Log.d("test", "LiveDataTestFragment: changeObserver")
        tv_frag_receiver.text = it
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        transformLiveData.observe(viewLifecycleOwner, changeObserver)
    }

}