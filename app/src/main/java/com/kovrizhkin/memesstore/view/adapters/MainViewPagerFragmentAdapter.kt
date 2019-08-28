package com.kovrizhkin.memesstore.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kovrizhkin.memesstore.view.screens.main.fragments.AddMemFragment
import com.kovrizhkin.memesstore.view.screens.main.fragments.MemListFragment
import com.kovrizhkin.memesstore.view.screens.main.fragments.ProfileFragment

class MainViewPagerFragmentAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MemListFragment()
            1 -> AddMemFragment()
            2 -> ProfileFragment()
            else -> MemListFragment()
        }
    }

    override fun getCount(): Int = NUM_ITEMS

    companion object {
        const val NUM_ITEMS = 3
    }
}