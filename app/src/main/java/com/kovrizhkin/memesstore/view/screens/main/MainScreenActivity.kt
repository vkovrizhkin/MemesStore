package com.kovrizhkin.memesstore.view.screens.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kovrizhkin.memesstore.R
import com.kovrizhkin.memesstore.view.ViewContract
import com.kovrizhkin.memesstore.view.screens.main.fragments.AddMemFragment
import com.kovrizhkin.memesstore.view.screens.main.fragments.MemListFragment
import com.kovrizhkin.memesstore.view.screens.main.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreenActivity : AppCompatActivity(), ViewContract.ITabNavigatorContainer {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        showView(MEMES_LIST_FRAGMENT_INDEX)
        initBottomBar()

    }

    override fun showLoading() {
        loadingBanner.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingBanner.visibility = View.GONE
    }

    override fun showView(tabIndex: Int) {

        currentFragment?.let {
            supportFragmentManager.beginTransaction().hide(it)
        }

        val addedFragment = supportFragmentManager.findFragmentByTag(tabIndex.toString())
        if (addedFragment != null) {
            supportFragmentManager.beginTransaction().show(addedFragment)
            currentFragment = addedFragment
        } else {
            val fragment = when (tabIndex) {
                MEMES_LIST_FRAGMENT_INDEX -> MemListFragment()
                ADD_MEM_FRAGMENT_INDEX -> AddMemFragment()
                PROFILE_FRAGMENT_INDEX -> ProfileFragment()
                else -> MemListFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tabIndex.toString())
                .commit()
            currentFragment = addedFragment
        }
    }

    private fun initBottomBar() {

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mem_list_tab -> showView(MEMES_LIST_FRAGMENT_INDEX)

                R.id.add_mem_tab -> showView(ADD_MEM_FRAGMENT_INDEX)

                R.id.profile_tab -> showView(PROFILE_FRAGMENT_INDEX)

            }
            return@setOnNavigationItemSelectedListener true
        }
    }


    companion object {
        const val MEMES_LIST_FRAGMENT_INDEX = 0

        const val ADD_MEM_FRAGMENT_INDEX = 1

        const val PROFILE_FRAGMENT_INDEX = 2
    }
}