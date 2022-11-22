package com.c22_067.whatdishtoday.ui.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.R

class Search : AppCompatActivity() {

private lateinit var rvSearch : RecyclerView
private val list = ArrayList<TempDataSearch>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        rvSearch = findViewById(R.id.rv_searchList)
        rvSearch.setHasFixedSize(true)

        list.addAll(listData)
        showRecyclerList()
    }
    private val listData: ArrayList<TempDataSearch>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val listSearch = ArrayList<TempDataSearch>()
            for (i in dataName.indices) {
                val search = TempDataSearch(dataName[i])
                listSearch.add(search)
            }
            return listSearch
        }
    private fun showRecyclerList() {
        rvSearch.layoutManager = LinearLayoutManager(this)
        val listSearchAdapter = ListSearchAdapter(list)
        rvSearch.adapter = listSearchAdapter
    }
}