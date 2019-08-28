package com.kovrizhkin.memesstore.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kovrizhkin.memesstore.R

class DetailMemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mem)
    }

    companion object {
        const val MEM_EXTRA_KEY = "MEM_EXTRA_KEY"
    }
}
