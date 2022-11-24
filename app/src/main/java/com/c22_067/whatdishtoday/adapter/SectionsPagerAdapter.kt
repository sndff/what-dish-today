package com.c22_067.whatdishtoday.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.c22_067.whatdishtoday.ui.home.home_fragments.*

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private val homeAllFragment = HomeAllFragment()
    private val homeCamilanFragment = HomeCamilanFragment()
    private val homeDagingFragment = HomeDagingFragment()
    private val homeKaloriFragment = HomeKaloriFragment()
    private val homePedasFragment = HomePedasFragment()
    private val homeSayuranFragment = HomeSayuranFragment()
    private val homeSopFragment = HomeSopFragment()

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = homeAllFragment.launchFragment()
            1 -> fragment = homeCamilanFragment.launchFragment()
            2 -> fragment = homeDagingFragment.launchFragment()
            3 -> fragment = homeKaloriFragment.launchFragment()
            4 -> fragment = homePedasFragment.launchFragment()
            5 -> fragment = homeSayuranFragment.launchFragment()
            6 -> fragment = homeSopFragment.launchFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 7
    }

}