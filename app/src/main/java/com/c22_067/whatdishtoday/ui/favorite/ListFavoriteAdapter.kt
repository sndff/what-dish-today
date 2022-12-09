package com.c22_067.whatdishtoday.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.c22_067.whatdishtoday.databinding.ItemFavoriteBinding
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem
import com.c22_067.whatdishtoday.ui.home.adapter.RecipeListsAdapter


class ListFavoriteAdapter (private  val listFav: ArrayList<TempFavorite>) : RecyclerView.Adapter<ListFavoriteAdapter.ListViewHolder>() {

//    private lateinit var onItemClick: OnItemClick
//
//    interface OnItemClick: AdapterView.OnItemClickListener{
//        fun onItemClicked(data: TempFavorite?)
//    }
//
//    fun setOnItemClickCallback(onItemClick: OnItemClick){
//        this.onItemClick = onItemClick
//    }

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
//        holder.itemView.setOnClickListener {
//            onItemClick.onItemClicked(listFav!![holder.adapterPosition])
//        }
    }

    override fun getItemCount(): Int = listFav.size
}