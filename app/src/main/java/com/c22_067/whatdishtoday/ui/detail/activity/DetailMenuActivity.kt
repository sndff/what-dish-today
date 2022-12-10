package com.c22_067.whatdishtoday.ui.detail.activity

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.FavoriteModel
import com.c22_067.whatdishtoday.databinding.ActivityDetailMenuBinding
import com.c22_067.whatdishtoday.databinding.FragmentDirectionsBinding
import com.c22_067.whatdishtoday.ui.detail.DetailViewModel
import com.c22_067.whatdishtoday.ui.detail.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DetailMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMenuBinding
    private lateinit var bindingDirections: FragmentDirectionsBinding
    private lateinit var viewModel: DetailViewModel

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMenuBinding.inflate(layoutInflater)
        bindingDirections = FragmentDirectionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser
        val key = intent.getStringExtra("key")
        val name = intent.getStringExtra("name")
        val photo = intent.getStringExtra("photo")

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        supportActionBar?.title = name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, key)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f

        db = Firebase.database.getReference("favorite")

        binding.favAdd.setOnClickListener{
          viewModel.addfavorite(
              key!!,
              name!!,
              photo!!,
              firebaseUser?.uid!!,
              db
          )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val KEY = "key"
        const val NAME = "name"
        const val PHOTO = "photo"
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.ingredients,
            R.string.directions,
            R.string.review
        )
    }
}