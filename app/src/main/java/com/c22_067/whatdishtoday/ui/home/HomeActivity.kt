package com.c22_067.whatdishtoday.ui.home

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.c22_067.whatdishtoday.MainActivity
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.databinding.ActivityHomeBinding
import com.c22_067.whatdishtoday.ui.favorite.FavoriteActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        onSearchRequested()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        auth = Firebase.auth
        val avatar = auth.currentUser?.photoUrl

        Glide.with(this)
            .load(avatar)
            .circleCrop()
            .into(binding.ivAvatar)

        viewModel.getRecipe(this, binding)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser
        if (firebaseUser == null) {
            // Not signed in, launch the Login activity
            startActivity(Intent(this, MainActivity::class.java))
            return
        }

    }

    override fun onSearchRequested(): Boolean {

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = binding.searchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.find(this@HomeActivity,binding,query)
                Toast.makeText(this@HomeActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
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
            R.id.logout->{
                signOut()
                true
            }
            else -> true
        }
    }

    private fun signOut() {
        auth.signOut()
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}