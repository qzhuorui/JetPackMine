package com.choryan.quan.jetpackmine.materialdesign

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.choryan.quan.jetpackmine.R
import kotlinx.android.synthetic.main.activity_material_design.*

/**
 * Created by ChoRyan Quan on 2021/12/2 11:46.
 * E-mail : qzhuorui@gmail.com
 * Function :
 */
class MaterialDesignActivity : AppCompatActivity(R.layout.activity_material_design) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_1.setOnClickListener { Toast.makeText(this, "click", Toast.LENGTH_SHORT).show() }
    }
}