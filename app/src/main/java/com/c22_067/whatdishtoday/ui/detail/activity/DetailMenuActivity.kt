package com.c22_067.whatdishtoday.ui.detail.activity

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.databinding.ActivityDetailMenuBinding
import com.c22_067.whatdishtoday.databinding.FragmentDirectionsBinding
import com.c22_067.whatdishtoday.ui.detail.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMenuBinding
    private lateinit var bindingDirections: FragmentDirectionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMenuBinding.inflate(layoutInflater)
        bindingDirections = FragmentDirectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val key = intent.getStringExtra("key")

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, key)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val KEY = "key"
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.ingredients,
            R.string.directions,
            R.string.review
        )
    }
}