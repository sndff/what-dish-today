package com.c22_067.whatdishtoday.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c22_067.whatdishtoday.databinding.ItemRvMainCategoryBinding
import com.c22_067.whatdishtoday.network.responses.ResultsRecipesItem
import com.c22_067.whatdishtoday.ui.home.DetailRecipeActivity

class MakananAdapter(private val context: Context, private var list: List<ResultsRecipesItem?>?) : RecyclerView.Adapter<MakananAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback : AdapterView.OnItemClickListener {
        fun onItemClicked(data: ResultsRecipesItem?)
    }

    inner class ViewHolder(val binding: ItemRvMainCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRvMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder((view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(list?.get(position)?.thumb)
            .into(holder.binding.imgDish)
        holder.binding.tvDishName.text = list?.get(position)?.key
        holder.binding.root.setOnClickListener {
            onItemClickCallback.onItemClicked(list?.get(position))
            val i = Intent(context, DetailRecipeActivity::class.java)
            i.putExtra(DetailRecipeActivity.DETAIL_RECIPE, list?.get(position)?.key)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int = list?.size!!
}