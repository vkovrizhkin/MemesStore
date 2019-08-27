package com.kovrizhkin.memesstore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.view.adapters.MainViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        viewPager.adapter = MainViewPagerFragmentAdapter(supportFragmentManager)
    }
}
