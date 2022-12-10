package com.c22_067.whatdishtoday.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.data.FavoriteModel
import com.c22_067.whatdishtoday.databinding.ItemFavoriteBinding
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem
import com.c22_067.whatdishtoday.ui.detail.activity.DetailMenuActivity
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ListFavoriteAdapter(
    options: FirebaseRecyclerOptions<FavoriteModel>,
) : FirebaseRecyclerAdapter<FavoriteModel, ListFavoriteAdapter.FavoriteViewHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_favorite, parent, false)
        val binding = ItemFavoriteBinding.bind(view)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int, model: FavoriteModel) {
        holder.bind(model)
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FavoriteModel) {
            binding.tvDishName.text = item.recipeName
            Glide.with(itemView.context)
                .load(item.photoUrl)
                .into(binding.imgDish)
            itemView.setOnClickListener{
                val intent = Intent(it.context, DetailMenuActivity::class.java)
                intent.putExtra(DetailMenuActivity.KEY,item.id)
                intent.putExtra(DetailMenuActivity.NAME,item.recipeName)
                intent.putExtra(DetailMenuActivity.PHOTO,item.photoUrl)
                it.context.startActivity(intent)
            }
        }
    }
}