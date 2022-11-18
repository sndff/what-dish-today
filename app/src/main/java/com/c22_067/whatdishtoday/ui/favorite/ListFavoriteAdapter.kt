package com.c22_067.whatdishtoday.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.ItemFavoriteBinding


class ListFavoriteAdapter (private  val listFav: ArrayList<TempFavorite>) : RecyclerView.Adapter<ListFavoriteAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,photo) = listFav[position]
        holder.binding.tvDishName.text = name
        holder.binding.imgDish.setImageResource(photo)
    }

    override fun getItemCount(): Int = listFav.size
}