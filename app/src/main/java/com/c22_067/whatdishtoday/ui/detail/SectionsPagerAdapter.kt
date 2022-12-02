package com.c22_067.whatdishtoday.ui.detail

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity, private val key: String?) : FragmentStateAdapter(activity) {

    private val direction = DirectionsFragment()

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = IngridientsFragment()
            1 -> fragment = direction.launchFragment(key)
            2 -> fragment = ReviewFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}