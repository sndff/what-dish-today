package com.c22_067.whatdishtoday.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.databinding.ActivityHomeBinding
import com.c22_067.whatdishtoday.ui.favorite.FavoriteActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModel.getRecipe(this, binding)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item : MenuItem): Boolean{
        return when (item.itemId) {
            R.id.favorite ->{
                val i = Intent(this, FavoriteActivity::class.java)
                startActivity(i)
                return true
            }
            else -> true
        }
    }
}