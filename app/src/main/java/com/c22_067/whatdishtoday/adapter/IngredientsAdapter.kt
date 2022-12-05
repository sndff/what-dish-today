package com.c22_067.whatdishtoday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.FragmentIngredientsBinding

class IngredientsAdapter(private val data: List<String?>?) : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentIngredientsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = data!!.size
}