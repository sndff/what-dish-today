package com.c22_067.whatdishtoday.ui.favorite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.R

class FavoriteActivity : AppCompatActivity() {

    private lateinit var rvfavorite : RecyclerView
    private val list = ArrayList<TempFavorite>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        rvfavorite = findViewById(R.id.rv_favorite)
        rvfavorite.setHasFixedSize(true)

        list.addAll(listFav)
        showRecyclerList()


    }
    private val listFav: ArrayList<TempFavorite>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listfav = ArrayList<TempFavorite>()
            for (i in dataName.indices) {
                val fav = TempFavorite(dataName[i],dataPhoto.getResourceId(i, -1))
                listfav.add(fav)
            }
            return listfav
        }
    private fun showRecyclerList() {
        rvfavorite.layoutManager = GridLayoutManager(this, 2)
        val listFavoriteAdapter = ListFavoriteAdapter(list)
        rvfavorite.adapter = listFavoriteAdapter
    }
}