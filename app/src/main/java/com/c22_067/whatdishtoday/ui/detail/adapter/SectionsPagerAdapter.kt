package com.c22_067.whatdishtoday.ui.detail.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.c22_067.whatdishtoday.ui.detail.fragment.DirectionsFragment
import com.c22_067.whatdishtoday.ui.detail.fragment.IngredientsFragment
import com.c22_067.whatdishtoday.ui.detail.fragment.ReviewFragment

class SectionsPagerAdapter(activity: AppCompatActivity, private val key: String?) : FragmentStateAdapter(activity) {

    private val direction = DirectionsFragment()
    private val ingredients = IngredientsFragment()
    private val review = ReviewFragment()

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ingredients.launchFragment(key)
            1 -> fragment = direction.launchFragment(key)
            2 -> fragment = review.launchFragment(key)
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}