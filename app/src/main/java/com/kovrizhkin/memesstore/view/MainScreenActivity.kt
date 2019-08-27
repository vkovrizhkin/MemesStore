package com.kovrizhkin.memesstore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.view.adapters.MainViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        viewPager.adapter = MainViewPagerFragmentAdapter(supportFragmentManager)

        syncViewPagerWithBottomBar(viewPager, bottomNavigationView)
    }

    private fun syncViewPagerWithBottomBar(viewPager: ViewPager, bottomBar: BottomNavigationView) {

        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mem_list_tab -> viewPager.currentItem = MEMES_LIST_FRAGMENT_INDEX
                R.id.add_mem_tab -> viewPager.currentItem = ADD_MEM_FRAGMENT_INDEX
                R.id.profile_tab -> viewPager.currentItem = PROFILE_FRAGMENT_INDEX
            }
            return@setOnNavigationItemSelectedListener true
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    MEMES_LIST_FRAGMENT_INDEX -> bottomBar.menu.getItem(MEMES_LIST_FRAGMENT_INDEX)
                        .isChecked = true
                    ADD_MEM_FRAGMENT_INDEX -> bottomBar.menu.getItem(ADD_MEM_FRAGMENT_INDEX)
                        .isChecked = true
                    PROFILE_FRAGMENT_INDEX -> bottomBar.menu.getItem(PROFILE_FRAGMENT_INDEX)
                        .isChecked = true
                }
            }

        })

    }

    companion object {
        const val MEMES_LIST_FRAGMENT_INDEX = 0

        const val ADD_MEM_FRAGMENT_INDEX = 1

        const val PROFILE_FRAGMENT_INDEX = 2
    }
}