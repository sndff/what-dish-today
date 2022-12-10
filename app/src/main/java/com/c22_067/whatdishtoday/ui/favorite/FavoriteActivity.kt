package com.c22_067.whatdishtoday.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.FavoriteModel
import com.c22_067.whatdishtoday.databinding.ActivityFavoriteBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FavoriteActivity : AppCompatActivity() {

    private val list = ArrayList<TempFavorite>()
    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var adapter: ListFavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite"
        binding.rvFavorite.layoutManager = GridLayoutManager(this, 2)


        showRecycle()

    }

    private fun showRecycle(){
        list.addAll(listFav)

        db = Firebase.database.getReference("favorite")
        auth = Firebase.auth
        val firebaseUser = auth.currentUser
        val uid = firebaseUser?.uid
        val query = db.child(uid!!)

        val options = FirebaseRecyclerOptions.Builder<FavoriteModel>()
            .setQuery(query, FavoriteModel::class.java)
            .setLifecycleOwner(this)
            .build()

        adapter = ListFavoriteAdapter(options)
        binding.rvFavorite.adapter = adapter

    }

    override fun onResume() {
        showRecycle()
        super.onResume()
    }

    private val listFav: ArrayList<TempFavorite>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listfav = ArrayList<TempFavorite>()
            for (i in dataName.indices) {
                val fav = TempFavorite(dataName[i], dataPhoto.getResourceId(i, -1))
                listfav.add(fav)
            }
            return listfav
        }
}