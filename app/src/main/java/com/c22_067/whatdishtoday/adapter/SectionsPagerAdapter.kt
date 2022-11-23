package com.dicoding.picodiploma.homerecipe.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.picodiploma.homerecipe.fragment.HomeAllFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        val fragment = HomeAllFragment()
        fragment.arguments = Bundle().apply {
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 7
    }

}